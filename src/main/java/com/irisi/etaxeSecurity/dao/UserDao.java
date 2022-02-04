package com.irisi.etaxeSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irisi.etaxeSecurity.bean.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
