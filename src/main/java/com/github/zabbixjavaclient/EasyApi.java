package com.github.zabbixjavaclient;

import static com.github.zabbixjavaclient.bean.HostgroupFilter.hostgroupFilter;
import static com.github.zabbixjavaclient.bean.get.HostGet.hostget;
import static com.github.zabbixjavaclient.bean.get.HostgroupGet.hostgroupget;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import com.github.zabbixjavaclient.bean.Host;
import com.github.zabbixjavaclient.bean.HostFilter;
import com.github.zabbixjavaclient.bean.Hostgroup;
import com.github.zabbixjavaclient.bean.Template;
import com.github.zabbixjavaclient.bean.TemplateFilter;
import com.github.zabbixjavaclient.bean.get.TemplateGet;

/**
 * @author Antoine Méausoone
 * 
 *         Some shortcuts methods for @see {@link ZabbixApi}
 *
 */
public class EasyApi {

	public static List<Host> getHostsByName(ZabbixApi api, String... hostNames) {
		return getHostsByName(api, newArrayList(hostNames));
	}

	public static List<Host> getHostsByName(ZabbixApi api, List<String> hostNames) {
		return api.getHosts(hostget().filter(HostFilter.filter().name(hostNames).build()).build());
	}

	public static Optional<Host> getHostByName(ZabbixApi api, String hostName) {
		return api.getHost(hostget().filter(HostFilter.filter().name(newArrayList(hostName)).build()).build());
	}

	public static List<Hostgroup> getHostgroupsByName(ZabbixApi api, List<String> hostgroupNames) {
		return api.getHostgroups(hostgroupget().filter(hostgroupFilter().name(hostgroupNames).build()).build());
	}

	public static Optional<Hostgroup> getHostgroupByName(ZabbixApi api, String hostgroupName) {
		return api.getHostgroup(hostgroupget().filter(hostgroupFilter().name(newArrayList(hostgroupName)).build())
				.build());
	}

	public static List<Template> getTemplatesByHost(ZabbixApi api, String... templateNames) {
		return getTemplatesByHost(api, newArrayList(templateNames));
	}

	public static List<Template> getTemplatesByHost(ZabbixApi api, List<String> templateNames) {
		return api.getTemplates(TemplateGet.templateget().filter(TemplateFilter.filter().host(templateNames).build())
				.build());
	}

	public static Optional<Template> getTemplateByHost(ZabbixApi api, String TemplateName) {
		return api.getTemplate(TemplateGet.templateget()
				.filter(TemplateFilter.filter().host(newArrayList(TemplateName)).build()).build());
	}

	public static List<Integer> deleteTemplatesByHostName(ZabbixApi api, List<String> templateNames) {
		List<Integer> templateIds = getTemplatesByHost(api, templateNames).stream()
				.map(template -> template.getTemplateid()).collect(toList());
		return api.deleteTemplates(templateIds);
	}
}
