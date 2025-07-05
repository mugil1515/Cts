// File: SpringDataJpaExample.java

package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;

// 1. Entity
@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Student() {}  // Default constructor

    public Student(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

// 2. Repository
interface StudentRepository extends JpaRepository<Student, Long> {}

// 3. Main Application
@SpringBootApplication
public class SpringDataJpaExample implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public SpringDataJpaExample(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaExample.class, args);
    }

    @Override
    public void run(String... args) {
        // Save students
        studentRepository.save(new Student("Alice"));
        studentRepository.save(new Student("Bob"));

        // Fetch and print all
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }
}
