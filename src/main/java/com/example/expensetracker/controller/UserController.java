package com.example.expensetracker.controller;

import com.example.expensetracker.model.User;
import com.example.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public String getUserByUsername(@PathVariable String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "user-profile"; // возвращаем страницу профиля пользователя
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // возвращаем страницу регистрации
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // возвращаем страницу логина
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "redirect:/auth/login"; // после регистрации перенаправляем на логин
    }
}