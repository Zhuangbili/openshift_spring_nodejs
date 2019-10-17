package com.sample.userinfo.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.userinfo.entity.UserInfo;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
public class UserInfoRepositoryTest {
	
	@Autowired
	UserInfoRepository uir;
	
	@Test
	public void testFindAll() {
		List<UserInfo> result = uir.findAll();
		
		result.stream().forEach(e-> {
			System.out.println(e.getName());
		});
		
		assertEquals(4, result.size());
	}

}
