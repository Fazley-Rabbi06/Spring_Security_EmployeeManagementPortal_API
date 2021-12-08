package com.fazley11372.employeemanagementportal.employees.controller;

import com.fazley11372.employeemanagementportal.employees.model.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/employee")
public class EmployeeManagementController {

    List<Employee> employees = List.of(
            new Employee(1,"fazley","Java"),
            new Employee(2,"fazla","Java"),
            new Employee(3,"farhan","Java"),
            new Employee(4,"rejaur","Java")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_HRAdmin','ROLE_HRExecutive')")
    public List<Employee> getAllEmployees(){
        return employees;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('HRAdmin:write')")
    public String registerNewEmployee(@RequestBody Employee employee){
        return "Successfully created new employee";
    }

    @DeleteMapping(path = "{employeeId}")
    @PreAuthorize("hasAuthority('HRAdmin:write')")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        return "Successfully Deleted";
    }

    @PutMapping(path = "{employeeId}")
    @PreAuthorize("hasAuthority('HRAdmin:write')")
    public String updateEmployee(@PathVariable("employeeId")Integer employeeId,@RequestBody Employee employee){
        return "Successfully Updated";

    }



}
