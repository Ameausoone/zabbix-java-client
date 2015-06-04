package com.github.zabbixjavaclient;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Slf4j
public class StandardTestZabbixApi {

	protected ZabbixApi zapi;

	@BeforeClass
	public void setUp() {
		SLF4JBridgeHandler.install();
		Logger LOGGER = Logger.getLogger("");
		LOGGER.setLevel(Level.ALL);
		Logger logger2 = Logger.getLogger("sun.net.www");
		logger2.setLevel(Level.ALL);
		zapi = ZabbixApiFactory.getZabbixApi("http://localhost:8080/zabbix", "admin", "zabbix");
	}

	@AfterClass
	public void cleanUp() {
		zapi.logout();
	}

}
