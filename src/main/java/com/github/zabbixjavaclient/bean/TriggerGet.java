package com.github.zabbixjavaclient.bean;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.zabbixjavaclient.bean.get.Get;
import com.github.zabbixjavaclient.bean.get.Query;
import com.github.zabbixjavaclient.bean.list.TriggerList;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class TriggerGet extends Get<Trigger, TemplateFilter> {

	@Builder(builderMethodName = "triggerget")
	public TriggerGet(Boolean countOutput, Boolean editable, Boolean excludeSearch, TemplateFilter filter,
			Integer limit, Query output, Boolean preservekeys, TemplateFilter search, Boolean searchByAny,
			Boolean searchWildcardsEnabled, List<String> sortfield, List<String> sortorder, Boolean startSearch,
			List<Integer> triggerids, List<Integer> groupids, List<Integer> templateids, List<Integer> hostids,
			List<Integer> itemids, List<Integer> applicationids, List<String> functions, String group, String host,
			Boolean inherited, Boolean templated, Boolean monitored, Boolean active, Boolean maintenance,
			Boolean withUnacknowledgedEvents, Boolean withAcknowledgedEvents, Boolean withLastEventUnacknowledged,
			Boolean skipDependent, Date lastChangeSince, Date lastChangeTill, Boolean only_true, Integer min_severity,
			Boolean expandComment, Boolean expandDescription, Boolean expandExpression, Query selectGroups,
			Query selectHosts, Query selectItems, Query selectFunctions, Query selectDependencies,
			Query selectDiscoveryRule, Query selectLastEvent) {
		super(countOutput, editable, excludeSearch, filter, limit, output, preservekeys, search, searchByAny,
				searchWildcardsEnabled, sortfield, sortorder, startSearch);
		this.triggerids = triggerids;
		this.groupids = groupids;
		this.templateids = templateids;
		this.hostids = hostids;
		this.itemids = itemids;
		this.applicationids = applicationids;
		this.functions = functions;
		this.group = group;
		this.host = host;
		this.inherited = inherited;
		this.templated = templated;
		this.monitored = monitored;
		this.active = active;
		this.maintenance = maintenance;
		this.withUnacknowledgedEvents = withUnacknowledgedEvents;
		this.withAcknowledgedEvents = withAcknowledgedEvents;
		this.withLastEventUnacknowledged = withLastEventUnacknowledged;
		this.skipDependent = skipDependent;
		this.lastChangeSince = lastChangeSince;
		this.lastChangeTill = lastChangeTill;
		this.only_true = only_true;
		this.min_severity = min_severity;
		this.expandComment = expandComment;
		this.expandDescription = expandDescription;
		this.expandExpression = expandExpression;
		this.selectGroups = selectGroups;
		this.selectHosts = selectHosts;
		this.selectItems = selectItems;
		this.selectFunctions = selectFunctions;
		this.selectDependencies = selectDependencies;
		this.selectDiscoveryRule = selectDiscoveryRule;
		this.selectLastEvent = selectLastEvent;
	}

	private List<Integer> triggerids;
	private List<Integer> groupids;
	private List<Integer> templateids;
	private List<Integer> hostids;
	private List<Integer> itemids;
	private List<Integer> applicationids;
	private List<String> functions;
	private String group;
	private String host;
	private Boolean inherited;
	private Boolean templated;
	private Boolean monitored;
	private Boolean active;
	private Boolean maintenance;
	private Boolean withUnacknowledgedEvents;
	private Boolean withAcknowledgedEvents;
	private Boolean withLastEventUnacknowledged;
	private Boolean skipDependent;
	private Date lastChangeSince;
	private Date lastChangeTill;
	private Boolean only_true;
	private Integer min_severity;
	private Boolean expandComment;
	private Boolean expandDescription;
	private Boolean expandExpression;
	private Query selectGroups;
	private Query selectHosts;
	private Query selectItems;
	private Query selectFunctions;
	private Query selectDependencies;
	private Query selectDiscoveryRule;
	private Query selectLastEvent;

	@Override
	public Class getListClass() {
		return TriggerList.class;
	}

}
