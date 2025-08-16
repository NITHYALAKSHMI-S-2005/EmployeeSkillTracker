package com.example.service.impl;

import com.example.dao.EmployeeDao;
import com.example.event.SkillAddedEvent;
import com.example.model.Employee;
import com.example.model.Skill;
import com.example.service.EmployeeService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final ApplicationEventPublisher eventPublisher;

    public EmployeeServiceImpl(EmployeeDao employeeDao, ApplicationEventPublisher eventPublisher) {
        this.employeeDao = employeeDao;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Employee addEmployee(String name) {
        Employee e = new Employee(null, name);
        return employeeDao.save(e);
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public Employee addSkill(Long employeeId, Skill skill) {
        Optional<Employee> opt = employeeDao.findById(employeeId);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Employee not found with id " + employeeId);
        }
        Employee e = opt.get();
        e.addSkill(skill);
        employeeDao.save(e);
        eventPublisher.publishEvent(new SkillAddedEvent(this, e.getId(), skill));
        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public List<Employee> findBySkill(String skillName) {
        return employeeDao.findBySkill(skillName);
    }

    @Override
    public List<Employee> findByRating(String rating) {
        return employeeDao.findByRating(rating);
    }
}