package com.irisi.etaxeSecurity.service.facade;


import com.irisi.etaxeSecurity.bean.Role;
import java.util.Collection;

public interface RoleService {
    Role save(Role role);

    void save(Collection<Role> roles);

    Role findByAuthority(String authority);
}
