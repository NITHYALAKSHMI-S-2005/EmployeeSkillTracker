package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Employee {
    private Long id;
    private String name;
    private final List<Skill> skills = Collections.synchronizedList(new ArrayList<>());

    public Employee() {}

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Skill> getSkills() { return skills; }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', skills=" + skills + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}