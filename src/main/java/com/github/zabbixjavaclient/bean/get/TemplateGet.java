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
import com.github.zabbixjavaclient.bean.Template;
import com.github.zabbixjavaclient.bean.TemplateFilter;
import com.github.zabbixjavaclient.bean.list.TemplateList;

/**
 * @author a118769
 * 
 *         There is an issue @Builder does not work with inheritance
 *
 */
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class TemplateGet extends Get<Template, TemplateFilter> {

	@Builder(builderMethodName = "templateget")
	public TemplateGet(Boolean countOutput, Boolean editable, Boolean excludeSearch, TemplateFilter filter,
			Integer limit, Query output, Boolean preservekeys, TemplateFilter search, Boolean searchByAny,
			Boolean searchWildcardsEnabled, List<String> sortfield, List<String> sortorder, Boolean startSearch,
			Query selectGroups, Query selectHosts, Query selectTemplates, Query selectParentTemplates,
			Query selectHttpTests, Query selectItems, Query selectDiscoveries, Query selectTriggers,
			Query selectGraphs, Query selectApplications, Query selectMacros, Query selectScreens, Integer limitSelects) {
		super(countOutput, editable, excludeSearch, filter, limitSelects, output, preservekeys, search, searchByAny,
				searchWildcardsEnabled, sortfield, sortorder, startSearch);
		this.selectGroups = selectGroups;
		this.selectHosts = selectHosts;
		this.selectTemplates = selectTemplates;
		this.selectParentTemplates = selectParentTemplates;
		this.selectHttpTests = selectHttpTests;
		this.selectItems = selectItems;
		this.selectDiscoveries = selectDiscoveries;
		this.selectTriggers = selectTriggers;
		this.selectGraphs = selectGraphs;
		this.selectApplications = selectApplications;
		this.selectMacros = selectMacros;
		this.selectScreens = selectScreens;
		this.limitSelects = limitSelects;
	}

	private Query selectGroups;
	private Query selectHosts;
	private Query selectTemplates;
	private Query selectParentTemplates;
	private Query selectHttpTests;
	private Query selectItems;
	private Query selectDiscoveries;
	private Query selectTriggers;
	private Query selectGraphs;
	private Query selectApplications;
	private Query selectMacros;
	private Query selectScreens;
	private Integer limitSelects;

	@SuppressWarnings("unchecked")
	@Override
	public Class getListClass() {
		return TemplateList.class;
	}

}
