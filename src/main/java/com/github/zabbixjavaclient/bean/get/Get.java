package com.github.zabbixjavaclient.bean.get;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Get<T, U> {

	public Get(Boolean countOutput, Boolean editable, Boolean excludeSearch, U filter, Integer limit, Query output,
			Boolean preservekeys, U search, Boolean searchByAny, Boolean searchWildcardsEnabled,
			List<String> sortfield, List<String> sortorder, Boolean startSearch) {
		super();
		this.countOutput = countOutput;
		this.editable = editable;
		this.excludeSearch = excludeSearch;
		this.filter = filter;
		this.limit = limit;
		this.output = output;
		this.preservekeys = preservekeys;
		this.search = search;
		this.searchByAny = searchByAny;
		this.searchWildcardsEnabled = searchWildcardsEnabled;
		this.sortfield = sortfield;
		this.sortorder = sortorder;
		this.startSearch = startSearch;
	}

	private Boolean countOutput;
	private Boolean editable;
	private Boolean excludeSearch;
	private U filter;
	private Integer limit;
	private Query output;
	private Boolean preservekeys;
	private U search;
	private Boolean searchByAny;
	private Boolean searchWildcardsEnabled;
	private List<String> sortfield;
	private List<String> sortorder;
	private Boolean startSearch;

	@JsonIgnore
	public abstract Class<List<T>> getListClass();

}
