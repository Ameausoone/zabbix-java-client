package com.github.zabbixjavaclient;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.googlecode.jsonrpc4j.JsonRpcClient;
import com.googlecode.jsonrpc4j.JsonRpcClient.RequestListener;

@Slf4j
public class ZbxRequestListener implements RequestListener {

	private String authToken = null;

	public ZbxRequestListener() {
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public void onBeforeRequestSent(JsonRpcClient client, ObjectNode request) {
		addAuthenticationMethod(request);
		if (log.isDebugEnabled()) {
			niceLog(request);
		}
	}

	private void niceLog(ObjectNode request) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String writeValueAsString = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(request);
			log.debug("Request :[{}]", writeValueAsString);
		} catch (IOException e) {
		}
	}

	private void addAuthenticationMethod(ObjectNode request) {
		if (authToken != null)
			request.put("auth", authToken);
	}

	@Override
	public void onBeforeResponseProcessed(JsonRpcClient client,
			ObjectNode response) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String writeValueAsString = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(response);
			log.debug("Response :[{}]", writeValueAsString);
		} catch (IOException e) {
		}
	}

}