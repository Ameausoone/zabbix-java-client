package com.github.zabbixjavaclient.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Builder(builderMethodName = "usergroup")
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usergroup {

	private String usrgrpid;
	private String name;
	private Integer debug_mode;
	private Integer gui_access;
	private Integer users_status;
}
