package com.hotel.ds_backend.repository;

import com.hotel.ds_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplyeeRepository extends JpaRepository<Employee, Long> {
}
