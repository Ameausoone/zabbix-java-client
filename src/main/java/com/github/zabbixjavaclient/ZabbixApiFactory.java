package com.github.zabbixjavaclient;

import static org.apache.commons.lang3.StringUtils.endsWith;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import com.github.zabbixjavaclient.ex.ZbxApiException;
import com.github.zabbixjavaclient.proxy.ZabbixApiHandler;
import com.google.common.collect.ImmutableMap;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

@Slf4j
public class ZabbixApiFactory {

	private static final String API_RESOURCE = "api_jsonrpc.php";
	private JsonRpcHttpClient rpcClient;
	private ZbxRequestListener requestListener;
	private String apiVersion;
	private String authToken;
	private String zbxUrl;
	private String user;
	private String password;

	private ZabbixApiFactory(String zbxUrl, String user, String password) {
		super();
		this.zbxUrl = zbxUrl;
		this.user = user;
		this.password = password;
		requestListener = new ZbxRequestListener();
	}

	public static ZabbixApi getZabbixApi(String zbxUrl, String user, String password) {
		ZabbixApiFactory factory = new ZabbixApiFactory(zbxUrl, user, password);
		factory.initRpcClient();
		factory.login();
		return factory.getApi();

	}

	private void initRpcClient() {
		if (!endsWith(zbxUrl, "/")) {
			zbxUrl = zbxUrl + "/";
		}
		URL serverURL = null;
		try {
			serverURL = new URL(zbxUrl + API_RESOURCE);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		rpcClient = new JsonRpcHttpClient(serverURL);
		rpcClient.setRequestListener(requestListener);
	}

	public void login() {
		try {
			apiVersion = rpcClient.invoke("apiinfo.version", null, String.class);
			log.info("Zabbix api version : [{}]", apiVersion);
			Map<String, String> params = ImmutableMap.of("user", user, "password", password);
			authToken = rpcClient.invoke("user.login", params, String.class);
			requestListener.setAuthToken(authToken);
			log.debug("Authentication successful for login : [{}]", user);
		} catch (Throwable e) {
			throw new ZbxApiException("Error during authentication step for login :[" + user + "].", e);
		}
	}

	public ZabbixApi getApi() {
		return (ZabbixApi) java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class<?>[] { ZabbixApi.class }, new ZabbixApiHandler(rpcClient));
	}
}
