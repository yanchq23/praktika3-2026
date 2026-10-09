package ru.example.studentapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.studentapp.model.Student;
import ru.example.studentapp.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) { this.studentService = studentService; }

    private boolean loggedIn(HttpSession session) { return Boolean.TRUE.equals(session.getAttribute("loggedIn")); }

    @GetMapping
    public String list(HttpSession session, Model model) {
        if (!loggedIn(session)) return "redirect:/login";
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("username", session.getAttribute("username"));
        return "students-list";
    }

    @GetMapping("/add")
    public String addForm(HttpSession session, Model model) {
        if (!loggedIn(session)) return "redirect:/login";
        model.addAttribute("student", new Student());
        return "students-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student student, HttpSession session) {
        if (!loggedIn(session)) return "redirect:/login";
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
