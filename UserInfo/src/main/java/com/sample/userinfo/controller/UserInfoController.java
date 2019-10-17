package com.sample.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.userinfo.repository.UserInfoRepository;
import com.sample.userinfo.entity.UserInfo;

@RestController
public class UserInfoController {
	
	@Autowired
	public UserInfoRepository uir;
	
	@GetMapping("/userinfo/all")
	public List<UserInfo> getUserInfoList() {
		return uir.findAll();
	}
	@GetMapping("/userinfo/search")
	public List<UserInfo> getUserInfoListByName(@RequestParam("name")String name) {
		return uir.findByName(name);
	}

}
