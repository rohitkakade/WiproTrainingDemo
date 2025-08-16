package com.example.employeemvc.service;

import com.example.employeemvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> searchEmployeesByName(String name);
    List<Employee> getAll();
}
