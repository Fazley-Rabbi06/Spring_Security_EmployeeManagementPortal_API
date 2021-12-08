package com.fazley11372.employeemanagementportal.auth.repository;

import com.fazley11372.employeemanagementportal.auth.model.ApplicationUser;

import java.util.Optional;


public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUserName(String username);

}
