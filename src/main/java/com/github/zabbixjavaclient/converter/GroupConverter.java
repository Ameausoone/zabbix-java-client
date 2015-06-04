package com.github.zabbixjavaclient.converter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupConverter extends ListToMapConverter<Integer> {

    @Override
    public String getIdKey() {
        return "groupid";
    }
}
