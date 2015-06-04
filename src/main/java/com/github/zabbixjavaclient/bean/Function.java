package com.github.zabbixjavaclient.bean;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @see https://www.zabbix.com/documentation/2.4/manual/api/reference/trigger/get
 *
 */
@Builder(builderMethodName = "trigger")
@Data
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Function {
	private Integer functionid;
	private Integer itemid;
	private String function;
	private String parameter;
}
