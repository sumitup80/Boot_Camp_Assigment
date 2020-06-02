package com.example.demo.services;

import static java.util.Collections.emptyList;

import com.example.demo.model.ApplicationUser;
import com.example.demo.repositories.ApplicationUserRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    RoleRepository roleRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        else{
            List<String> roleList=applicationUser.getUserRoles().stream().map(userRole -> roleRepository.findById(userRole.getRoleId()).get()).
                    map(role->role.getRoleName()).collect(Collectors.toList());

            List<GrantedAuthority> authorities = roleList.stream().map(roleName ->
                    new SimpleGrantedAuthority(roleName)
            ).collect(Collectors.toList());
            return new User(applicationUser.getUsername(), applicationUser.getPassword(), authorities);
        }

    }


}