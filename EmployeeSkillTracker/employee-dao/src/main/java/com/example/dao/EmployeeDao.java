package com.example.dao;

import com.example.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    List<Employee> findBySkill(String skillName);
    List<Employee> findByRating(String rating);
}