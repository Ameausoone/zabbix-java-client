package com.github.zabbixjavaclient.bean;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.zabbixjavaclient.converter.GroupConverter;
import com.github.zabbixjavaclient.converter.MacroDeserializer;
import com.github.zabbixjavaclient.converter.TemplateConverter;

/**
 * 
 * @see https://www.zabbix.com/documentation/2.4/manual/api/reference/host/object#host
 * @author a118769
 *
 */
@Builder(builderMethodName = "zbxhost")
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Host {

    private final Integer hostid = null;

    @NotNull
    private String host = null;

    private Integer available = null;

    private String description = null;

    private Date disable_until = null;

    private String error = null;

    private Date errors_from = null;

    private Integer flags = null;

    private Integer ipmi_authtype;

    private Integer ipmi_available;

    private Date ipmi_disable_until;

    private String ipmi_error;

    private Date ipmi_errors_from;

    private String ipmi_password;

    private Integer ipmi_privilege;

    private String ipmi_username;

    private Integer jmx_available;

    private Date jmx_disable_until;

    private String jmx_error;

    private Date jmx_errors_from;

    private Date maintenance_from;

    private Integer maintenance_status;

    private Integer maintenance_type;

    private String maintenanceid;

    private String name;

    private Integer proxy_hostid;

    private Integer snmp_available;

    private Date snmp_disable_until;

    private String snmp_error;

    private Date snmp_errors_from;

    private Integer status;

    @NotEmpty
    @JsonSerialize(converter = GroupConverter.class)
    private List<Integer> groups = newArrayList();

    @NotEmpty
    @Valid
    @Singular
    private List<Interface> interfaces = newArrayList();

    @JsonSerialize(converter = TemplateConverter.class)
    private List<Integer> templates = newArrayList();

    @JsonDeserialize(using = MacroDeserializer.class)
    private Map<String, String> macros = newHashMap();

    private Map<String, String> inventory = newHashMap();

}
