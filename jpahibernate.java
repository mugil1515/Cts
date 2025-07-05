// File: JpaVsHibernateVsSpringDataExample.java

package com.example;

import javax.persistence.*; // JPA annotations
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;
import java.util.List;

// ✅ 1. JPA: Entity defined using JPA annotations
@Entity
@Table(name = "students")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate handles strategy
    private Long id;

    private String name;

    public Student() {}  // Default constructor
    public Student(String name) { this.name = name; }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

// ✅ 2. Spring Data JPA: Auto-implemented repository
interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name); // Spring Data JPA query method
}

// ✅ 3. Spring Boot App
@SpringBootApplication
public class JpaVsHibernateVsSpringDataExample {

    public static void main(String[] args) {
        SpringApplication.run(JpaVsHibernateVsSpringDataExample.class, args);
    }

    // ✅ 4. Inject repository and use
    @Bean
    public CommandLineRunner run(StudentRepository repo) {
        return args -> {
            // Save students
            repo.save(new Student("Alice"));
            repo.save(new Student("Bob"));

            // Fetch all students
            repo.findAll().forEach(System.out::println);

            // Fetch by name (Spring Data JPA query)
            repo.findByName("Alice").forEach(s -> System.out.println("Found: " + s));
        };
    }
}
