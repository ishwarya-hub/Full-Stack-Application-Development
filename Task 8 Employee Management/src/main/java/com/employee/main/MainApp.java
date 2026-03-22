package com.employee.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.service.EmployeeService;

/**
 * MainApp – Entry point for the Spring Core Employee Management application.
 *
 * Flow:
 *  1. Spring container is initialised by loading beans.xml
 *  2. beans.xml triggers a component-scan of com.employee package
 *  3. Spring auto-detects @Component classes: EmployeeRepository, EmployeeService
 *  4. Spring wires EmployeeRepository into EmployeeService via @Autowired (IoC / DI)
 *  5. BeanFactory.getBean() returns the fully-wired EmployeeService bean
 *  6. Business methods are called – employees are added and displayed
 *
 * Spring Concepts Demonstrated:
 *   IoC (Inversion of Control)  → Spring creates and manages all beans
 *   DI  (Dependency Injection)  → Spring injects EmployeeRepository into EmployeeService
 *   BeanFactory                 → Spring container interface used to retrieve beans
 *   beans.xml                   → XML configuration for component scanning
 */
public class MainApp {

    public static void main(String[] args) {

        System.out.println("=== Spring Container Starting ===");

        // Step 1: Load Spring container (IoC) from classpath beans.xml
        BeanFactory factory =
                new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("=== Spring Container Initialised ===");

        // Step 2: Retrieve the EmployeeService bean (DI is already done by Spring)
        EmployeeService service = factory.getBean(EmployeeService.class);

        // Step 3: Use the service to add employees (no database – in-memory only)
        service.createEmployee(101, "Arun",  "IT");
        service.createEmployee(102, "Priya", "HR");

        // Step 4: Display all employees
        service.displayEmployees();

        // Step 5: Close the context to release resources
        ((ClassPathXmlApplicationContext) factory).close();

        System.out.println("=== Application Finished ===");
    }
}
