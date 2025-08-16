# 👩‍💻 Employee Skill Tracker (Spring Core Multi-Module Project)

## 📌 Project Overview
The **Employee Skill Tracker** is a **Spring Core-based multi-module project** that manages employee records and their skill sets.  
It demonstrates the use of **Spring Core features like Dependency Injection (DI) and Inversion of Control (IoC)** to build a modular, maintainable, and scalable enterprise-level application.  

This project helps HR teams and managers to:
- Maintain employee details  
- Assign and manage employee skills  
- Generate reports of workforce skill sets  

Unlike Spring Boot, this project is built purely with **Spring Core and XML-based configuration**, showcasing a strong understanding of **bean wiring and modular architecture**.

---

## 🛠 Tech Stack
- **Programming Language**: Java  
- **Framework**: Spring Core (DI & IoC)  
- **Build Tool**: Maven (multi-module)  
- **Database**: JDBC with MySQL / H2 (configurable)  
- **Testing**: JUnit  

---

## 📂 Modules
### 1️⃣ Employee Module
- Manages CRUD operations for employee data  
- Handles basic employee details (ID, name, designation, department)  

### 2️⃣ Skill Module
- Defines skills and proficiency levels  
- Allows assigning multiple skills to employees  

### 3️⃣ Tracker Module
- Provides reporting functionalities  
- Tracks employees with their skills and generates consolidated output  

### 4️⃣ Common/Shared Module
- Contains common POJOs (Employee, Skill, etc.)  
- Holds utilities and shared configuration files  

---

## 📂 Project Structure
EmployeeSkillTrackerMultiModule/
├── common-module
│ ├── src/main/java/com/est/common/Employee.java
│ ├── src/main/java/com/est/common/Skill.java
│ └── src/main/resources/applicationContext.xml
│
├── employee-module
│ └── src/main/java/com/est/employee/EmployeeService.java
│
├── skill-module
│ └── src/main/java/com/est/skill/SkillService.java
│
├── tracker-module
│ └── src/main/java/com/est/tracker/TrackerService.java
│
└── pom.xml

---

## 🚀 Features
- ➕ Add, update, delete, and list employees  
- 📑 Define and manage skills with proficiency levels (Beginner, Intermediate, Expert)  
- 🔗 Assign multiple skills to each employee  
- 📊 Generate consolidated skill reports  
- 🧩 Modular structure for scalability  
- ⚙️ Uses **Spring Core DI/IoC** for loose coupling  

---

## 📝 Sample Configuration (`applicationContext.xml`)
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
          http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Employee Bean -->
    <bean id="employeeService" class="com.est.employee.EmployeeService">
        <property name="skillService" ref="skillService"/>
    </bean>

    <!-- Skill Bean -->
    <bean id="skillService" class="com.est.skill.SkillService" />

    <!-- Tracker Bean -->
    <bean id="trackerService" class="com.est.tracker.TrackerService">
        <property name="employeeService" ref="employeeService"/>
        <property name="skillService" ref="skillService"/>
    </bean>
</beans>
▶️ How to Run

Clone the repository:

git clone https://github.com/YOUR-USERNAME/EmployeeSkillTrackerMultiModule.git
cd EmployeeSkillTrackerMultiModule


Build the project with Maven:

mvn clean install


Run the main application class:

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.est.tracker.TrackerService;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackerService tracker = context.getBean("trackerService", TrackerService.class);
        tracker.generateReport();
    }
}


View the output in the console (since this is a Spring Core project, not a web app).

📊 Example Console Output
--- Employee Skill Report ---
Employee: Nithya (ID: 101, Dept: ECE)
Skills:
 - Java (Expert)
 - SQL (Intermediate)
 - Spring Core (Beginner)

Employee: Divya (ID: 102, Dept: CSE)
Skills:
 - Python (Intermediate)
 - MATLAB (Expert)
-----------------------------

📊 Future Enhancements

🔒 Add authentication & authorization (Spring Security)

🗄️ Integrate ORM layer with Hibernate for persistence

🌐 Build REST APIs with Spring Boot on top of this core system

📊 Add frontend dashboard for visualization

🤝 Contributor

Nithyalakshmi S – Developer

