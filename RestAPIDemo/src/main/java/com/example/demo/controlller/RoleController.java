package com.example.demo.controlller;

import com.example.demo.model.ApplicationUser;
import com.example.demo.model.Role;
import com.example.demo.repositories.ApplicationUserRepository;
import com.example.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/role")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        roleRepository.save(role);

        return new ResponseEntity<>(role, HttpStatus.OK);

    }

}