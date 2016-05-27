package com.example.employee.service.impl;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findOne(Long id) {
        return Optional.ofNullable(employeeRepository.findOne(id));
    }

    @Override
    public Optional<Employee> create(Employee employee) {
        Optional<Employee> empOp = Optional.ofNullable(employeeRepository.save(employee));
        return empOp;
    }

    @Override
    public Optional<Employee> update(Long id, Employee toUpd) {
        Optional<Employee> empOp = findOne(id);
        if (empOp.isPresent()) {
            EmployeeUtils.copyFields.apply(empOp.get(), toUpd);
        }
        return empOp;
    }

    @Override
    public boolean delete(Long id) {
        try {
            employeeRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
