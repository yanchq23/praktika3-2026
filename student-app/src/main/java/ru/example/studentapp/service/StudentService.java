package ru.example.studentapp.service;

import org.springframework.stereotype.Service;
import ru.example.studentapp.model.Student;
import ru.example.studentapp.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) { this.repository = repository; }
    public List<Student> getAllStudents() { return repository.findAll(); }
    public Student saveStudent(Student student) { return repository.save(student); }
}
