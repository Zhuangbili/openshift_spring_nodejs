package com.sample.userinfo.repository;

import java.util.List;

import com.sample.userinfo.entity.UserInfo;

public interface CustomUserInfoRepository {

	public List<UserInfo> findByName(String name);
}
