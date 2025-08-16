package com.example.service;

import com.example.config.AppConfig;
import com.example.model.Employee;
import com.example.model.Skill;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceTest {

    private static AnnotationConfigApplicationContext ctx;
    private static EmployeeService service;

    @BeforeAll
    public static void init() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        service = ctx.getBean(EmployeeService.class);
    }

    @AfterAll
    public static void shutdown() {
        if (ctx != null) ctx.close();
    }

    @Test
    public void testAddEmployeeAndRetrieve() {
        Employee e = service.addEmployee("TestUser");
        Assertions.assertNotNull(e.getId());
        Optional<Employee> found = service.getEmployee(e.getId());
        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals("TestUser", found.get().getName());
    }

    @Test
    public void testAddSkillAndSearch() {
        Employee e = service.addEmployee("SkillUser");
        service.addSkill(e.getId(), new Skill("Java", "Expert"));
        List<Employee> javaDevs = service.findBySkill("Java");
        Assertions.assertFalse(javaDevs.isEmpty());
        Assertions.assertEquals(e.getId(), javaDevs.get(0).getId());
    }
}