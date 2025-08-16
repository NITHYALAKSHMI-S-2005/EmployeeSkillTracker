package com.example.service;

import com.example.model.Employee;
import com.example.model.Skill;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(String name);
    Optional<Employee> getEmployee(Long id);
    Employee addSkill(Long employeeId, Skill skill);
    List<Employee> getAllEmployees();
    List<Employee> findBySkill(String skillName);
    List<Employee> findByRating(String rating);
}