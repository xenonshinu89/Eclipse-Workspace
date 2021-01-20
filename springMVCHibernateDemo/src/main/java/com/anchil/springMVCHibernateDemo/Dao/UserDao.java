package com.anchil.springMVCHibernateDemo.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anchil.springMVCHibernateDemo.Model.User;


public interface UserDao extends JpaRepository<User,Integer>{
	
	Optional<User> findByUserName(String userName);
		

}
