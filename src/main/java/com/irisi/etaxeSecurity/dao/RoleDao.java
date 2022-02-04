package com.irisi.etaxeSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irisi.etaxeSecurity.bean.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
	Role findByAuthority(String authority);
}
