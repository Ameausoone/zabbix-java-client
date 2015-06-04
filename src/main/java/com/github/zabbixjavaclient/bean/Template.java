package com.github.zabbixjavaclient.bean;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.zabbixjavaclient.converter.GroupConverter;
import com.github.zabbixjavaclient.converter.HostConverter;
import com.github.zabbixjavaclient.converter.MacroDeserializer;
import com.github.zabbixjavaclient.converter.TemplateConverter;

/**
 * @see https://www.zabbix.com/documentation/2.4/manual/api/reference/template/object
 * 
 * @author a118769
 *
 */
@Builder(builderMethodName = "zbxTemplate")
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Template {

	private Integer templateid;

	@NotEmpty
	private String host;

	private String description;

	private String name;

	@NotEmpty
	private List<Integer> groupIds = newArrayList();

	private List<Hostgroup> groups = newArrayList();

	private List<Trigger> triggers = newArrayList();

	private List<Item> items = newArrayList();

	@JsonSerialize(converter = GroupConverter.class)
	@JsonProperty("groups")
	public List<Integer> getGroupIds() {
		return groupIds;
	}

	@JsonProperty("groups")
	public void setGroups(List<Hostgroup> groups) {
		this.groups = groups;
	}

	@JsonIgnore
	private List<Integer> templateIds = newArrayList();

	private List<Template> templates;

	private List<Template> parentTemplates;

	@JsonSerialize(converter = TemplateConverter.class)
	@JsonProperty("templates")
	public List<Integer> getTemplateIds() {
		return templateIds;
	}

	@JsonProperty("templates")
	@JsonDeserialize
	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public void setParentTemplates(List<Template> parentTemplates) {
		this.parentTemplates = parentTemplates;
	}

	@JsonDeserialize(using = MacroDeserializer.class)
	private Map<String, String> macros = newHashMap();

	private List<Integer> hostIds = newArrayList();

	@JsonIgnore
	private List<Host> hosts = newArrayList();

	@JsonSerialize(converter = HostConverter.class)
	@JsonProperty("hosts")
	public List<Integer> getHostIds() {
		return hostIds;
	}

	@JsonProperty("hosts")
	@JsonDeserialize
	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

}
