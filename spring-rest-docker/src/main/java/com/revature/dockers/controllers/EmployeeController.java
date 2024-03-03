package com.revature.dockers.controllers;

import com.revature.dockers.model.Employee;
import com.revature.dockers.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
public List<Employee> getEmployees(){
    return employeeRepository.findAll();
}

@PostMapping("/employees")
public void saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
}
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return employeeRepository.findById(id);
    }
}
