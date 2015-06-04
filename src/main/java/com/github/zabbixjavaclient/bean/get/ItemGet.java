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
import com.github.zabbixjavaclient.bean.Item;
import com.github.zabbixjavaclient.bean.get.filter.ItemFilter;
import com.github.zabbixjavaclient.bean.list.ItemList;

@Data
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class ItemGet extends Get<Item, ItemFilter> {

	@Builder(builderMethodName = "itemGet")
	public ItemGet(Boolean countOutput, Boolean editable, Boolean excludeSearch, ItemFilter filter, Integer limit,
			Query output, Boolean preservekeys, ItemFilter search, Boolean searchByAny, Boolean searchWildcardsEnabled,
			List<String> sortfield, List<String> sortorder, Boolean startSearch, List<Integer> itemids,
			List<Integer> groupids, List<Integer> templateids, List<Integer> hostids, List<Integer> proxyids,
			List<Integer> interfaceids, List<Integer> graphids, List<Integer> triggerids, List<Integer> applicationids,
			Boolean webitems, Boolean inherited, Boolean templated, Boolean monitored, String group, String host,
			String application, Boolean with_triggers, Query selectHosts, Query selectInterfaces, Query selectTriggers,
			Query selectGraphs, Query selectApplications, Query selectDiscoveryRule) {
		super(countOutput, editable, excludeSearch, filter, limit, output, preservekeys, search, searchByAny,
				searchWildcardsEnabled, sortfield, sortorder, startSearch);
		this.itemids = itemids;
		this.groupids = groupids;
		this.templateids = templateids;
		this.hostids = hostids;
		this.proxyids = proxyids;
		this.interfaceids = interfaceids;
		this.graphids = graphids;
		this.triggerids = triggerids;
		this.applicationids = applicationids;
		this.webitems = webitems;
		this.inherited = inherited;
		this.templated = templated;
		this.monitored = monitored;
		this.group = group;
		this.host = host;
		this.application = application;
		this.with_triggers = with_triggers;
		this.selectHosts = selectHosts;
		this.selectInterfaces = selectInterfaces;
		this.selectTriggers = selectTriggers;
		this.selectGraphs = selectGraphs;
		this.selectApplications = selectApplications;
		this.selectDiscoveryRule = selectDiscoveryRule;
	}

	private List<Integer> itemids;
	private List<Integer> groupids;
	private List<Integer> templateids;
	private List<Integer> hostids;
	private List<Integer> proxyids;
	private List<Integer> interfaceids;
	private List<Integer> graphids;
	private List<Integer> triggerids;
	private List<Integer> applicationids;
	private Boolean webitems;
	private Boolean inherited;
	private Boolean templated;
	private Boolean monitored;
	private String group;
	private String host;
	private String application;
	private Boolean with_triggers;
	private Query selectHosts;
	private Query selectInterfaces;
	private Query selectTriggers;
	private Query selectGraphs;
	private Query selectApplications;
	private Query selectDiscoveryRule;

	@Override
	public Class getListClass() {
		return ItemList.class;
	}

}
