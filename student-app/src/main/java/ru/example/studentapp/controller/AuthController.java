package ru.example.studentapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.studentapp.service.UserService;

@Controller
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @GetMapping("/")
    public String home() { return "redirect:/login"; }

    @GetMapping("/login")
    public String loginForm() { return "login-form"; }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, Model model) {
        if (userService.authenticate(username, password)) {
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username.trim());
            return "redirect:/students";
        }
        model.addAttribute("error", "Неверный логин или пароль");
        return "login-form";
    }

    @GetMapping("/register")
    public String registerForm() { return "register-form"; }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.register(username, password)) return "redirect:/login";
        model.addAttribute("error", "Заполните поля и выберите свободный логин");
        return "register-form";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
