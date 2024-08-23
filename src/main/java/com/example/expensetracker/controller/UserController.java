package com.example.expensetracker.controller;

import com.example.expensetracker.model.User;
import com.example.expensetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register"; // Возвращаем страницу регистрации с ошибками
        }
        userService.saveUser(user);
        return "redirect:/auth/login"; // После успешной регистрации перенаправляем на логин
    }
}