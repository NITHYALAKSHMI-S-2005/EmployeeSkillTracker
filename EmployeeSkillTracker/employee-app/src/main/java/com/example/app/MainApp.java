package com.example.app;

import com.example.config.AppConfig;
import com.example.model.Employee;
import com.example.model.Skill;
import com.example.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = ctx.getBean(EmployeeService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Employee Skill Tracker ===");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Skill to Employee");
            System.out.println("3. List All Employees");
            System.out.println("4. Search by Skill");
            System.out.println("5. Search by Rating");
            System.out.println("6. Get Employee by ID");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Employee name: ");
                        String name = scanner.nextLine().trim();
                        Employee e = service.addEmployee(name);
                        System.out.println("Added: " + e);
                    }
                    case "2" -> {
                        System.out.print("Employee ID: ");
                        Long id = Long.parseLong(scanner.nextLine().trim());
                        System.out.print("Skill name: ");
                        String sname = scanner.nextLine().trim();
                        System.out.print("Skill rating (Beginner/Intermediate/Expert): ");
                        String rating = scanner.nextLine().trim();
                        Skill skill = new Skill(sname, rating);
                        Employee updated = service.addSkill(id, skill);
                        System.out.println("Updated: " + updated);
                    }
                    case "3" -> {
                        List<Employee> all = service.getAllEmployees();
                        all.forEach(System.out::println);
                    }
                    case "4" -> {
                        System.out.print("Skill name: ");
                        String sname = scanner.nextLine().trim();
                        List<Employee> found = service.findBySkill(sname);
                        found.forEach(System.out::println);
                    }
                    case "5" -> {
                        System.out.print("Rating: ");
                        String rating = scanner.nextLine().trim();
                        List<Employee> found = service.findByRating(rating);
                        found.forEach(System.out::println);
                    }
                    case "6" -> {
                        System.out.print("Employee ID: ");
                        Long id = Long.parseLong(scanner.nextLine().trim());
                        Optional<Employee> emp = service.getEmployee(id);
                        System.out.println(emp.orElse(null));
                    }
                    case "7" -> {
                        System.out.println("Exiting...");
                        ctx.close();
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}