package com.github.zabbixjavaclient.bean;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;

/**
 * @see https ://www.zabbix.com/documentation/2.4/manual/api/reference/trigger/object
 *
 */
@Builder(builderMethodName = "trigger")
@Data
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trigger {

	private Integer triggerid;

	@NotNull
	private String description;

	@NotNull
	private String expression;

	private String comments;

	private String error;

	private Integer flags;

	private Date lastchange;

	private Integer priority;

	private Integer state;

	private Integer status;

	private Integer templateid;

	private Integer type;

	private String url;

	private Integer value;

	private List<Function> functions = Lists.newArrayList();
}
