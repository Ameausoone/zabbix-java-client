package com.github.zabbixjavaclient.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Builder(builderMethodName = "item")
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private Integer itemid;

	@NotNull
	private Integer delay;

	@NotNull
	private Integer hostid;

	private Integer interfaceid;

	@NotNull
	private String key_;

	@NotNull
	private String name;

	@NotNull
	private Integer type;

	@NotNull
	private Integer value_type;

	private Integer authtype;
	private Integer data_type;
	private String delay_flex;
	private Integer delta;
	private String description;
	private String error;
	private Integer flags;
	private Float formula;
	private Integer history;
	private Integer inventory_link;
	private String ipmi_sensor;
	private Date lastclock;
	private Integer lastns;
	private String lastvalue;
	private String logtimefmt;
	private Date mtime;
	private Integer multiplier;
	private String params;
	private String password;
	private String port;
	private String prevvalue;
	private String privatekey;
	private String publickey;
	private String snmp_community;
	private String snmp_oid;
	private String snmpv3_authpassphrase;
	private Integer snmpv3_authprotocol;
	private String snmpv3_contextname;
	private String snmpv3_privpassphrase;
	private Integer snmpv3_privprotocol;
	private Integer snmpv3_securitylevel;
	private String snmpv3_securityname;
	private Integer state;
	private Integer status;
	private String templateid;
	private String trapper_hosts;
	private Integer trends;
	private String units;
	private String username;
	private String valuemapid;
}
