package com.example.dao.impl;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import com.example.model.Skill;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final ConcurrentHashMap<Long, Employee> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idGenerator.incrementAndGet());
        }
        store.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Employee> findBySkill(String skillName) {
        return store.values().stream()
                .filter(e -> e.getSkills().stream()
                        .anyMatch(s -> s.getName().equalsIgnoreCase(skillName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByRating(String rating) {
        return store.values().stream()
                .filter(e -> e.getSkills().stream()
                        .anyMatch(s -> s.getRating().equalsIgnoreCase(rating)))
                .collect(Collectors.toList());
    }
}