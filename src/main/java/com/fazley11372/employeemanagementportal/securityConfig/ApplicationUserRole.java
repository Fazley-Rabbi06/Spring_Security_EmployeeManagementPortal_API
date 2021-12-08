package com.fazley11372.employeemanagementportal.securityConfig;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.fazley11372.employeemanagementportal.securityConfig.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    HRAdmin(Sets.newHashSet(HRADMIN_READ,HRADMIN_WRITE)),
    HRExecutive(Sets.newHashSet(HREXECUTIVE_READ)),
    Employee(Sets.newHashSet(EMPLOYEE_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }

}
