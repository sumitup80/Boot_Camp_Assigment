package com.example.demo.services;

import com.example.demo.model.Orders;
import com.example.demo.model.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role saveRole(Role role) {
        Role insertedRole=roleRepository.save(role);
        return insertedRole;
    }


}
