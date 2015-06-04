package com.github.zabbixjavaclient.converter;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.google.common.collect.ImmutableMap;

public abstract class ListToMapConverter<T> extends StdConverter<List<T>, List<Map<String, String>>> {

    @Override
    public List<Map<String, String>> convert(List<T> ids) {
        List<Map<String, String>> result = newArrayList();
        for (T id : ids) {
            result.add(ImmutableMap.of(getIdKey(), String.valueOf(id)));
        }
        return result;
    }

    public abstract String getIdKey();
}
