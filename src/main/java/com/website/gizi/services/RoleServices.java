package com.website.gizi.services;

import com.website.gizi.dao.RoleDao;
import com.website.gizi.model.Role;
import com.website.gizi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServices implements RoleDao {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        List<Role> rl = new ArrayList<>();
        roleRepository.findAll().forEach(rl::add);
        return rl;
    }

    @Override
    public Role getRoleById(long id) {
        Role r = roleRepository.findById(id).get();
        return r;
    }

    @Override
    public Role SaveOrUpdateRole(Role a) {
        roleRepository.save(a);
        return a;
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void deleteRole(Role a) {
        roleRepository.delete(a);
    }
}
