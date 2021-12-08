package com.fazley11372.employeemanagementportal.securityConfig;

public enum ApplicationUserPermission {

    HRADMIN_READ("HrAdmin:read"),
    HRADMIN_WRITE("HRAdmin:write"),
    HREXECUTIVE_READ("HRExecutive:read"),
    EMPLOYEE_READ("Employee:read");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
