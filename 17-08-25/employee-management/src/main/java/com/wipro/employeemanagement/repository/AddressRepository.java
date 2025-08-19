package com.wipro.employeemanagement.repository;

import com.wipro.employeemanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
