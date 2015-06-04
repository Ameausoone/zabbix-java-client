package com.github.zabbixjavaclient.converter;


public class HostConverter extends ListToMapConverter<Integer> {

    @Override
    public String getIdKey() {
        return "hostid";
    }
}
