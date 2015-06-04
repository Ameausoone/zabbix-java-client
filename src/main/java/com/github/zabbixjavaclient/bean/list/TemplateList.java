package com.github.zabbixjavaclient.bean.list;

import java.util.ArrayList;

import com.github.zabbixjavaclient.bean.Template;

/**
 * @author a118769
 * 
 *         Because jackson cannot deserialize Generic List.
 * 
 * @see http://stackoverflow.com/questions/24318910/java-lang-classcastexception-java-util-linkedhashmap-cannot-be-cast
 *
 */
public class TemplateList extends ArrayList<Template> {

    private static final long serialVersionUID = -646699475559577927L;

}
