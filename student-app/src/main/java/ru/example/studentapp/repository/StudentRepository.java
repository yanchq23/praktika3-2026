package ru.example.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.studentapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> { }
