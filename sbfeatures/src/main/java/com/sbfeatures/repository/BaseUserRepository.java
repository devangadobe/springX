package com.sbfeatures.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbfeatures.entity.BaseUser;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long>{
	
	@Query(value="select bu from BaseUser bu where bu.userName like %?1")
	List<BaseUser> findByUserNameEndsWith(String userName);

}
