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
import com.github.zabbixjavaclient.bean.Application;
import com.github.zabbixjavaclient.bean.ApplicationFilter;
import com.github.zabbixjavaclient.bean.list.ApplicationList;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class ApplicationGet extends Get<Application, ApplicationFilter> {

	@Builder(builderMethodName = "applicationget")
	public ApplicationGet(Boolean countOutput, Boolean editable, Boolean excludeSearch, ApplicationFilter filter,
			Integer limit, Query output, Boolean preservekeys, ApplicationFilter search, Boolean searchByAny,
			Boolean searchWildcardsEnabled, List<String> sortfield, List<String> sortorder, Boolean startSearch,
			List<Integer> applicationids, List<Integer> groupids, List<Integer> hostids, Boolean inherited,
			List<Integer> itemids, Boolean templated, List<Integer> templateids, Query selectHost, Query selectItems) {
		super(countOutput, editable, excludeSearch, filter, limit, output, preservekeys, search, searchByAny,
				searchWildcardsEnabled, sortfield, sortorder, startSearch);
		this.applicationids = applicationids;
		this.groupids = groupids;
		this.hostids = hostids;
		this.inherited = inherited;
		this.itemids = itemids;
		this.templated = templated;
		this.templateids = templateids;
		this.selectHost = selectHost;
		this.selectItems = selectItems;
	}

	private List<Integer> applicationids;
	private List<Integer> groupids;
	private List<Integer> hostids;
	private Boolean inherited;
	private List<Integer> itemids;
	private Boolean templated;
	private List<Integer> templateids;
	private Query selectHost;
	private Query selectItems;

	@Override
	public Class getListClass() {
		return ApplicationList.class;
	}

}
