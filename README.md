# Zabbix java client

This project is a Java client for Zabbix API. zabbix java client uses jsonrpc4j (https://github.com/briandilley/jsonrpc4j) library.

## Maven

This project is built with [Maven], and compile with Java 8.


In `<dependencies>`:

```xml

	<!-- zabbix java client -->
	<dependency>
		<groupId>com.github.zabbixjavaclient</groupId>
		<artifactId>zabbix-java-client</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</dependency>

```

## Usage

```java
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
```

## API 

This client is aim to be use with Zabbix 2.4, api reference is available here : https://www.zabbix.com/documentation/2.4/manual/api. A small part of the
API is implemented for now, contributions are welcomed.

## Contributions

Client implements methods get, create, update and delete for elements : Application, Host, Hostgroup, Interface, Item, Template, Trigger.

Client is designed, so it's only necessary to add java bean for elements, and add method on ZabbixApi interface. Method signature should follow simple name convention (*actionElement*).


