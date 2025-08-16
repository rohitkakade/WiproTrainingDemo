package com.example.employeemvc.service.impl;

import com.example.employeemvc.entity.Employee;
import com.example.employeemvc.exception.EmployeeNotFoundException;
import com.example.employeemvc.repository.EmployeeRepository;
import com.example.employeemvc.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        existing.setName(employee.getName());
        existing.setType(employee.getType());
        existing.setAddress(employee.getAddress());
        existing.setDepartment(employee.getDepartment());
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public List<Employee> searchEmployeesByName(String name) {
        if(name == null || name.isBlank()){
            return employeeRepository.findAll();
        }
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
