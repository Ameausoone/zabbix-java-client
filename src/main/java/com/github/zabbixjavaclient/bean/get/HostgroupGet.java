package com.github.zabbixjavaclient.bean.get;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.zabbixjavaclient.bean.Hostgroup;
import com.github.zabbixjavaclient.bean.get.filter.HostgroupFilter;
import com.github.zabbixjavaclient.bean.list.HostgroupList;

@Data
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class HostgroupGet extends Get<Hostgroup, HostgroupFilter> {

	@Builder(builderMethodName = "hostgroupget")
	public HostgroupGet(Boolean countOutput, Boolean editable, Boolean excludeSearch, HostgroupFilter filter,
			Integer limit, Query output, Boolean preservekeys, HostgroupFilter search, Boolean searchByAny,
			Boolean searchWildcardsEnabled, List<String> sortfield, List<String> sortorder, Boolean startSearch,
			List<Integer> graphids, List<Integer> groupids, List<Integer> hostids, List<Integer> maintenanceids,
			Boolean monitored_hosts, Boolean real_hosts, Boolean templated_hosts, List<Integer> templateids,
			List<Integer> triggerids, Boolean with_applications, Boolean with_graphs, Boolean with_hosts_and_templates,
			Boolean with_httptests, Boolean with_items, Boolean with_monitored_httptests, Boolean with_monitored_items,
			Boolean with_monitored_triggers, Boolean with_simple_graph_items, Boolean with_triggers,
			Query selectDiscoveryRule, Query selectGroupDiscovery, Query selectHosts, Query selectTemplates) {
		super(countOutput, editable, excludeSearch, filter, limit, output, preservekeys, search, searchByAny,
				searchWildcardsEnabled, sortfield, sortorder, startSearch);
		this.graphids = graphids;
		this.groupids = groupids;
		this.hostids = hostids;
		this.maintenanceids = maintenanceids;
		this.monitored_hosts = monitored_hosts;
		this.real_hosts = real_hosts;
		this.templated_hosts = templated_hosts;
		this.templateids = templateids;
		this.triggerids = triggerids;
		this.with_applications = with_applications;
		this.with_graphs = with_graphs;
		this.with_hosts_and_templates = with_hosts_and_templates;
		this.with_httptests = with_httptests;
		this.with_items = with_items;
		this.with_monitored_httptests = with_monitored_httptests;
		this.with_monitored_items = with_monitored_items;
		this.with_monitored_triggers = with_monitored_triggers;
		this.with_simple_graph_items = with_simple_graph_items;
		this.with_triggers = with_triggers;
		this.selectDiscoveryRule = selectDiscoveryRule;
		this.selectGroupDiscovery = selectGroupDiscovery;
		this.selectHosts = selectHosts;
		this.selectTemplates = selectTemplates;
	}

	private List<Integer> graphids;
	private List<Integer> groupids;
	private List<Integer> hostids;
	private List<Integer> maintenanceids;
	private Boolean monitored_hosts;
	private Boolean real_hosts;
	private Boolean templated_hosts;
	private List<Integer> templateids;
	private List<Integer> triggerids;
	private Boolean with_applications;
	private Boolean with_graphs;
	private Boolean with_hosts_and_templates;
	private Boolean with_httptests;
	private Boolean with_items;
	private Boolean with_monitored_httptests;
	private Boolean with_monitored_items;
	private Boolean with_monitored_triggers;
	private Boolean with_simple_graph_items;
	private Boolean with_triggers;
	private Query selectDiscoveryRule;
	private Query selectGroupDiscovery;
	private Query selectHosts;
	private Query selectTemplates;

	@Override
	public Class getListClass() {
		return HostgroupList.class;
	}
}
