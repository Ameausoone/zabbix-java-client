package com.github.zabbixjavaclient.bean.get;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.zabbixjavaclient.bean.Host;
import com.github.zabbixjavaclient.bean.get.filter.HostFilter;
import com.github.zabbixjavaclient.bean.list.HostList;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class HostGet extends Get<Host, HostFilter> {

	@Builder(builderMethodName = "hostget")
	public HostGet(Boolean countOutput, Boolean editable, Boolean excludeSearch, HostFilter filter, Integer limit,
			Query output, Boolean preservekeys, HostFilter search, Boolean searchByAny, Boolean searchWildcardsEnabled,
			List<String> sortfield, List<String> sortorder, Boolean startSearch, List<Integer> groupids,
			List<Integer> applicationids, List<Integer> dserviceids, List<Integer> graphids, List<Integer> hostids,
			List<Integer> httptestids, List<Integer> interfaceids, List<Integer> itemids, List<Integer> maintenanceids,
			Boolean monitored_hosts, Boolean proxy_hosts, List<Integer> proxyids, Boolean templated_hosts,
			List<Integer> templateids, List<Integer> triggerids, Boolean with_items, Boolean with_applications,
			Boolean with_graphs, Boolean with_httptests, Boolean with_monitored_httptests,
			Boolean with_monitored_items, Boolean with_monitored_triggers, Boolean with_simple_graph_items,
			Boolean with_triggers, Boolean withInventory, Query selectGroups, Query selectApplications,
			Query selectDiscoveries, Query selectDiscoveryRule, Query selectGraphs, Query selectHostDiscovery,
			Query selectHttpTests, Query selectInterfaces, Query selectInventory, Query selectItems,
			Query selectMacros, Query selectParentTemplates, Query selectScreens, Query selectTriggers,
			Integer limitSelects, Object searchInventory) {
		super(countOutput, editable, excludeSearch, filter, limit, output, preservekeys, search, searchByAny,
				searchWildcardsEnabled, sortfield, sortorder, startSearch);
		this.groupids = groupids;
		this.applicationids = applicationids;
		this.dserviceids = dserviceids;
		this.graphids = graphids;
		this.hostids = hostids;
		this.httptestids = httptestids;
		this.interfaceids = interfaceids;
		this.itemids = itemids;
		this.maintenanceids = maintenanceids;
		this.monitored_hosts = monitored_hosts;
		this.proxy_hosts = proxy_hosts;
		this.proxyids = proxyids;
		this.templated_hosts = templated_hosts;
		this.templateids = templateids;
		this.triggerids = triggerids;
		this.with_items = with_items;
		this.with_applications = with_applications;
		this.with_graphs = with_graphs;
		this.with_httptests = with_httptests;
		this.with_monitored_httptests = with_monitored_httptests;
		this.with_monitored_items = with_monitored_items;
		this.with_monitored_triggers = with_monitored_triggers;
		this.with_simple_graph_items = with_simple_graph_items;
		this.with_triggers = with_triggers;
		this.withInventory = withInventory;
		this.selectGroups = selectGroups;
		this.selectApplications = selectApplications;
		this.selectDiscoveries = selectDiscoveries;
		this.selectDiscoveryRule = selectDiscoveryRule;
		this.selectGraphs = selectGraphs;
		this.selectHostDiscovery = selectHostDiscovery;
		this.selectHttpTests = selectHttpTests;
		this.selectInterfaces = selectInterfaces;
		this.selectInventory = selectInventory;
		this.selectItems = selectItems;
		this.selectMacros = selectMacros;
		this.selectParentTemplates = selectParentTemplates;
		this.selectScreens = selectScreens;
		this.selectTriggers = selectTriggers;
		this.limitSelects = limitSelects;
		this.searchInventory = searchInventory;
	}

	private List<Integer> groupids;
	private List<Integer> applicationids;
	private List<Integer> dserviceids;
	private List<Integer> graphids;
	private List<Integer> hostids;
	private List<Integer> httptestids;
	private List<Integer> interfaceids;
	private List<Integer> itemids;
	private List<Integer> maintenanceids;
	private Boolean monitored_hosts;
	private Boolean proxy_hosts;
	private List<Integer> proxyids;
	private Boolean templated_hosts;
	private List<Integer> templateids;
	private List<Integer> triggerids;
	private Boolean with_items;
	private Boolean with_applications;
	private Boolean with_graphs;
	private Boolean with_httptests;
	private Boolean with_monitored_httptests;
	private Boolean with_monitored_items;
	private Boolean with_monitored_triggers;
	private Boolean with_simple_graph_items;
	private Boolean with_triggers;
	private Boolean withInventory;
	private Query selectGroups;
	private Query selectApplications;
	private Query selectDiscoveries;
	private Query selectDiscoveryRule;
	private Query selectGraphs;
	private Query selectHostDiscovery;
	private Query selectHttpTests;
	private Query selectInterfaces;
	private Query selectInventory;
	private Query selectItems;
	private Query selectMacros;
	private Query selectParentTemplates;
	private Query selectScreens;
	private Query selectTriggers;
	private Integer limitSelects;
	private Object searchInventory;

	@Override
	public Class getListClass() {
		return HostList.class;
	}
}
