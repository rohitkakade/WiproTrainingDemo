package com.example.employeemvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    // Contract | Regular
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Employee() {}

    public Employee(String name, String type, Department department, Address address) {
        this.name = name;
        this.type = type;
        this.department = department;
        this.address = address;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
