package com.github.zabbixjavaclient;

import java.util.List;
import java.util.Optional;

import com.github.zabbixjavaclient.bean.Application;
import com.github.zabbixjavaclient.bean.Host;
import com.github.zabbixjavaclient.bean.Hostgroup;
import com.github.zabbixjavaclient.bean.Item;
import com.github.zabbixjavaclient.bean.Template;
import com.github.zabbixjavaclient.bean.Trigger;
import com.github.zabbixjavaclient.bean.get.ApplicationGet;
import com.github.zabbixjavaclient.bean.get.HostGet;
import com.github.zabbixjavaclient.bean.get.HostgroupGet;
import com.github.zabbixjavaclient.bean.get.ItemGet;
import com.github.zabbixjavaclient.bean.get.TemplateGet;
import com.github.zabbixjavaclient.bean.get.TriggerGet;

public interface ZabbixApi {

	public Optional<Integer> createApplication(Application app);

	public List<Integer> createApplications(List<Application> app);

	public List<Application> getApplications(ApplicationGet getParam);

	public Optional<Integer> createHostgroup(Hostgroup hostgroup);

	public List<Integer> createHostgroups(List<Hostgroup> hostgroups);

	public Optional<Integer> updateHostgroup(Hostgroup hostgroup);

	public List<Integer> updateHostgroups(List<Hostgroup> hostgroup);

	public Optional<Integer> deleteHostgroup(Integer groupid);

	public List<Integer> deleteHostgroups(List<Integer> groupids);

	public Optional<Integer> createTemplate(Template template);

	public List<Integer> createTemplates(List<Template> templates);

	/**
	 * Delete template specified by templateId
	 * 
	 * @param templateId
	 * @return
	 */
	public Optional<Integer> deleteTemplate(Integer templateId);

	/**
	 * Delete template according to templatesIds parameter
	 * 
	 * @param templateIds
	 *            templateid of template to delete.
	 * @return templateId of template which have been deleted
	 */
	public List<Integer> deleteTemplates(List<Integer> templateIds);

	public Optional<Integer> createHost(Host host);

	public List<Integer> createHosts(Host... host);

	public List<Integer> createHosts(List<Host> hosts);

	public Optional<Integer> deleteHost(Integer hostId);

	public List<Integer> deleteHosts(List<Integer> hostIds);

	public Optional<Item> getItem(ItemGet itemGet);

	public List<Item> getItems(ItemGet getParam);

	public List<Trigger> getTriggers(TriggerGet getParams);

	public List<Integer> createItems(List<Item> items);

	public List<Integer> createTriggers(List<Trigger> triggers);

	public List<Hostgroup> getHostgroups(HostgroupGet getParam);

	public Optional<Hostgroup> getHostgroup(HostgroupGet getParam);

	public List<Host> getHosts(HostGet get);

	public Optional<Host> getHost(HostGet get);

	public Optional<Template> getTemplate(TemplateGet get);

	public List<Template> getTemplates(TemplateGet get);

	public Boolean logout();
}
