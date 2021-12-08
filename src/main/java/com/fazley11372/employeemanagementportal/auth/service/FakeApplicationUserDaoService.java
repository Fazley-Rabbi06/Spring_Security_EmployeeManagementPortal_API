package com.fazley11372.employeemanagementportal.auth.service;

import com.fazley11372.employeemanagementportal.auth.model.ApplicationUser;
import com.fazley11372.employeemanagementportal.auth.repository.ApplicationUserDao;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import static com.fazley11372.employeemanagementportal.securityConfig.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUsers()
                .stream()
                .filter((applicationUser -> username.equals(applicationUser.getUsername())))
                .findFirst();
    }

    List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "admin",
                        passwordEncoder.encode("222"),
                        HRAdmin.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "executive",
                        passwordEncoder.encode("333"),
                        HRExecutive.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "employee",
                        passwordEncoder.encode("111"),
                        Employee.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;
    }
}
