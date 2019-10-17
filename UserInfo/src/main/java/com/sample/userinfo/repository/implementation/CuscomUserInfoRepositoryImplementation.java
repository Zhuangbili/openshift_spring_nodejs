package com.sample.userinfo.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sample.userinfo.entity.UserInfo;
import com.sample.userinfo.repository.CustomUserInfoRepository;

@Repository
@Transactional
public class CuscomUserInfoRepositoryImplementation implements CustomUserInfoRepository {

	@PersistenceContext
    EntityManager entityManager;
	
	private String searchUserInfoByNameQuery = "select * from UserInfo where name = ?";
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> findByName(String name) {
		Query query = entityManager.createNativeQuery(searchUserInfoByNameQuery,UserInfo.class);
		query.setParameter(1, "%"+name+"%");
		return query.getResultList();
	}

}
