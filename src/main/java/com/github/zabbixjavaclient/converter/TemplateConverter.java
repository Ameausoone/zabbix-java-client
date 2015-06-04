package com.github.zabbixjavaclient.converter;

public class TemplateConverter extends ListToMapConverter<Integer> {

    @Override
    public String getIdKey() {
        return "templateid";
    }
}
