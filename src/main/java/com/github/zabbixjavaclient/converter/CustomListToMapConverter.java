package com.github.zabbixjavaclient.converter;

public class CustomListToMapConverter<T> extends ListToMapConverter<T> {

    private String key;

    public CustomListToMapConverter(String key) {
        this.key = key;
    }

    @Override
    public String getIdKey() {
        return key;
    }

}
