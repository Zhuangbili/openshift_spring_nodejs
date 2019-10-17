package com.sample.userinfo.repository;

import com.sample.userinfo.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> , CustomUserInfoRepository {

}
