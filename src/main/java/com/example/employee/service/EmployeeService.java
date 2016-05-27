package com.example.employee.service;

import com.example.employee.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by huta on 26.05.16.
 */
public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findOne(Long id);
    Optional<Employee> create(Employee employee);
    Optional<Employee> update(Long id, Employee employee);
    boolean delete(Long id);
}
