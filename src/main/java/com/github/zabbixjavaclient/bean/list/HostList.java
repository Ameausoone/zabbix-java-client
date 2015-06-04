package com.github.zabbixjavaclient.bean.list;

import java.util.ArrayList;

import com.github.zabbixjavaclient.bean.Host;

/**
 * @author Antoine Méausoone
 * 
 *         Because jackson cannot deserialize Generic List.
 * 
 * @see http://stackoverflow.com/questions/24318910/java-lang-classcastexception-java-util-linkedhashmap-cannot-be-cast
 *
 */
public class HostList extends ArrayList<Host> {

    private static final long serialVersionUID = -4361572566570940349L;

}
