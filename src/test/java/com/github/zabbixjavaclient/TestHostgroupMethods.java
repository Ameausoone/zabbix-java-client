package com.github.zabbixjavaclient;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Optional;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.github.zabbixjavaclient.bean.Hostgroup;
import com.github.zabbixjavaclient.bean.get.HostgroupGet;

public class TestHostgroupMethods extends StandardTestZabbixApi {

	private Integer groupid;

	@Test
	public void testCreateHostgroup() {
		zapi.createHostgroup(Hostgroup.hostgroup().name("Hostgroup 4 test").build());
	}

	@Test(dependsOnMethods = "testCreateHostgroup")
	public void testGetHostgroup() {
		Optional<Hostgroup> hostgroupByName = EasyApi.getHostgroupByName(zapi, "Hostgroup 4 test");
		assertThat(hostgroupByName.isPresent()).isTrue();
		assertThat(hostgroupByName.get().getName()).isEqualTo("Hostgroup 4 test");
		groupid = hostgroupByName.get().getGroupid();
	}

	@Test(dependsOnMethods = "testGetHostgroup")
	public void testUpdateHostgroup() {
		zapi.updateHostgroup(com.github.zabbixjavaclient.bean.Hostgroup.hostgroup().groupid(groupid)
				.name("New Hostgroup Name").build());
		Optional<Hostgroup> hostgroup = zapi.getHostgroup(HostgroupGet.hostgroupget().groupids(newArrayList(groupid))
				.build());
		assertThat(hostgroup.isPresent()).isTrue();
		assertThat(hostgroup.get().getName()).isEqualTo("New Hostgroup Name");
	}

	@Test(dependsOnMethods = "testUpdateHostgroup")
	public void testDeleteHostgroup() {
		Optional<Integer> deleteHostgroup = zapi.deleteHostgroup(groupid);
		assertThat(deleteHostgroup.isPresent()).isTrue();
	}

	@AfterClass
	public void cleanUp() {
		try {
			testDeleteHostgroup();
		} catch (Throwable t) {
		}
	}
}
