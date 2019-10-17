package com.sample.userinfo.controller;



import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.userinfo.entity.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class UserInfoControllerTest {

	@Autowired
	UserInfoController uic;

	@Test
	public void testGetUserInfoList() {
		List<UserInfo> result = uic.getUserInfoList();

		result.stream().forEach(e -> {
			System.out.println(e.getName());
		});
		assertEquals(4, result.size());
	}
	
	@Test
	public void testgetUserInfoListByName() {
		String name = "alexa";
		
		List<UserInfo> result = uic.getUserInfoListByName(name);
		assertEquals(1, result.size());
		UserInfo userInfo = result.get(0);
		
		assertEquals("Amazon", userInfo.getAddress());
		assertEquals(5, userInfo.getAge());
		assertEquals("abcdefg", userInfo.getUuid());
	}

}
