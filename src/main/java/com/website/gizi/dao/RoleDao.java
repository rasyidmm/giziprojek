package com.website.gizi.dao;

import com.website.gizi.model.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> getAllRole();
    public Role getRoleById(long id);
    public Role SaveOrUpdateRole(Role a);
    public void deleteRoleById(long id);
    public void deleteRole(Role a);
}
