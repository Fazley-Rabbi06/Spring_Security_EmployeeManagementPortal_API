package com.fazley11372.employeemanagementportal.employees.controller;

import com.fazley11372.employeemanagementportal.employees.model.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    List<Employee> employees = List.of(
            new Employee(1,"fazley","Java"),
            new Employee(2,"fazla","Java"),
            new Employee(3,"farhan","Java"),
            new Employee(4,"rejaur","Java")
            );

    @GetMapping("/")
    public int countTotalEmployee(){
        return employees.size();
    }

    @GetMapping(path = "/employee/{eID}")
    @PreAuthorize("hasAnyRole('ROLE_Employee','ROLE_HRExecutive','ROLE_HRAdmin')")
    public Employee getEmployee(@PathVariable("eID")Integer employeeId){
        Employee emp = employees.stream()
                .filter(employee -> employeeId.equals(employee.getId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Employee "+employeeId+" not found."));
        return emp;

    }
}
