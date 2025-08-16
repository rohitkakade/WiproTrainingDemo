package com.example.employeemvc.controller;

import com.example.employeemvc.entity.Address;
import com.example.employeemvc.entity.Department;
import com.example.employeemvc.entity.Employee;
import com.example.employeemvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String listEmployees(@RequestParam(value = "q", required = false) String q, Model model){
        model.addAttribute("employees", employeeService.searchEmployeesByName(q));
        model.addAttribute("q", q == null ? "" : q);
        return "employees";
    }

    @GetMapping("/employees/add")
    public String showAddForm(Model model){
        Employee e = new Employee();
        e.setDepartment(new Department());
        e.setAddress(new Address());
        model.addAttribute("employee", e);
        return "add-employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit-employee";
    }

    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee){
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // Simple search by ID using path
    @GetMapping("/employees/{id}")
    public String viewById(@PathVariable Long id, Model model){
        model.addAttribute("employees", java.util.List.of(employeeService.getEmployeeById(id)));
        model.addAttribute("q", "");
        return "employees";
    }
}
