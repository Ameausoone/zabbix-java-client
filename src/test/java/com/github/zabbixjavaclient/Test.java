package com.github.zabbixjavaclient;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Optional;

import com.github.zabbixjavaclient.bean.Application;
import com.github.zabbixjavaclient.bean.get.ApplicationGet;

public class Test {

	public static void main(String[] args) {
		ZabbixApi zabbixApi = ZabbixApiFactory.getZabbixApi("http://zabbix/", "login", "password");

		Optional<Integer> optionalApplicationId = zabbixApi.createApplication(Application.application().name("My New application").build());

		ApplicationGet getParam = ApplicationGet.applicationget().applicationids(newArrayList(optionalApplicationId.get())).build();
		
		List<Application> applications = zabbixApi.getApplications(getParam);
	}
}
