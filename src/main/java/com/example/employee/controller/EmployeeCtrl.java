package com.example.employee.controller;

import java.util.List;
import java.util.Optional;

import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/users")
public class EmployeeCtrl {

	@Autowired
    EmployeeService employeeService;
	
	@RequestMapping(path="/list", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Employee> list() {
		return employeeService.findAll();
	}


	@RequestMapping(path="/create", method=RequestMethod.POST)
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Optional<Employee> empOp = employeeService.create(employee);
        if (empOp.isPresent()) {
            return new ResponseEntity<>(empOp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

    @RequestMapping(path="/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
    public ResponseEntity<Employee> get(@PathVariable("id") Long id) {
        Optional<Employee> empOp = employeeService.findOne(id);
        if (empOp.isPresent()) {
            return new ResponseEntity<Employee>(empOp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE, produces="application/json; charset=UTF-8")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return employeeService.delete(id) ? new ResponseEntity<Void>(HttpStatus.ACCEPTED) : new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(path="/update/{id}", method=RequestMethod.PUT, produces="application/json; charset=UTF-8")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Optional<Employee> empOp = employeeService.update(id, employee);
        if (empOp.isPresent()) {
            return new ResponseEntity<Employee>(empOp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(Exception e) {
        return "rerror";
    }

}
