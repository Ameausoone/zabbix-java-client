package com.github.zabbixjavaclient;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.zabbixjavaclient.bean.Application;
import com.github.zabbixjavaclient.bean.Item;
import com.github.zabbixjavaclient.bean.Template;
import com.github.zabbixjavaclient.bean.Trigger;
import com.github.zabbixjavaclient.bean.get.ApplicationGet;
import com.github.zabbixjavaclient.bean.get.ItemGet;
import com.github.zabbixjavaclient.bean.get.Query;
import com.github.zabbixjavaclient.bean.get.TemplateGet;
import com.github.zabbixjavaclient.bean.get.TriggerGet;
import com.github.zabbixjavaclient.bean.get.filter.ApplicationFilter;
import com.github.zabbixjavaclient.bean.get.filter.TemplateFilter;

@Slf4j
public class TestZabbixApi {

	private ZabbixApi zapi;

	@BeforeClass
	public void setUp() {
		SLF4JBridgeHandler.install();
		Logger LOGGER = Logger.getLogger("");
		LOGGER.setLevel(Level.ALL);
		Logger logger2 = Logger.getLogger("sun.net.www");
		logger2.setLevel(Level.ALL);
		zapi = ZabbixApiFactory.getZabbixApi("http://localhost:8080/zabbix", "admin", "zabbix");
	}

	@Test
	public void testZabbixApi() throws JsonGenerationException, JsonMappingException, IOException {
		Optional<Template> template = zapi.getTemplate(TemplateGet.templateget()
				.filter(TemplateFilter.filter().name(newArrayList("Template App HTTPS Service")).build()).build());
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		File resultFile = new File("target/template1.yaml");
		mapper.writeValue(resultFile, template.get());
	}

	@Test
	public void testGetItem() throws JsonGenerationException, JsonMappingException, IOException {
		ItemGet itemGet2 = ItemGet.itemGet().host("Template App HTTPS Service").build();
		List<Item> items = zapi.getItems(itemGet2);
		log.info("items : [{}]", items);
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		File resultFile = new File("target/item1.yaml");
		mapper.writeValue(resultFile, items.get(0));
	}

	@Test
	public void testGetTrigger() throws JsonGenerationException, JsonMappingException, IOException {
		TriggerGet getParams = TriggerGet.triggerget().host("Template App HTTPS Service").selectFunctions(Query.extend)
				.build();
		List<Trigger> triggers = zapi.getTriggers(getParams);
		assertThat(triggers.size()).isEqualTo(1);
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		File resultFile = new File("target/trigger1.yaml");
		mapper.writeValue(resultFile, triggers.get(0));
	}

	@Test
	public void testGetApplication() {
		ArrayList<String> list = newArrayList("FTP service");
		ApplicationFilter filter = ApplicationFilter.filter().name(list).build();
		ApplicationGet getParam = ApplicationGet.applicationget().filter(filter).build();
		List<Application> applications = zapi.getApplications(getParam);
		Optional<Application> first = applications.stream().findFirst();
		assertThat(first.isPresent()).isTrue();
		assertThat(first.get().getName()).isEqualTo("FTP service");
	}
}
