package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmployeeCreateRequest;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeCreateRequest request) {
        return employeeService.createEmoployeeWithProfile(
                request.getName(),
                request.getEmail(),
                request.getProfile().getPhone(),
                request.getProfile().getAddress()
        );
    }

    @GetMapping
    public List<Employee> all() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee byId(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "Deleted employee id = " + id;
    }
}
