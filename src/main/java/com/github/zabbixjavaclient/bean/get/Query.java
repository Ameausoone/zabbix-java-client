package com.github.zabbixjavaclient.bean.get;

/**
 * https://www.zabbix.com/documentation/2.4/manual/api/reference_commentary
 * 
 * A value which defines, what data should be returned.
 * 
 */
public enum Query {
    /**
     * returns all object properties;
     */
    extend,
    /**
     * returns the number of retrieved records, supported only by certain subselects.
     */
    count;
}
