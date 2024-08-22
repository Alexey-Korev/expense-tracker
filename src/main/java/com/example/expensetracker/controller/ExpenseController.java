package com.example.expensetracker.controller;


import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseType;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String getAllExpenses(Principal principal, Model model) {
        List<Expense> expenses = expenseService.getAllExpensesByUser(principal.getName());
        model.addAttribute("expenses", expenses);
        return "expenses"; // возвращаем страницу расходов
    }

    @GetMapping("/type/{type}")
    public String getExpensesByType(@PathVariable ExpenseType type, Principal principal, Model model) {
        List<Expense> expenses = expenseService.getExpensesByTypeAndUser(type, principal.getName());
        model.addAttribute("expenses", expenses);
        return "expenses-by-type"; // возвращаем страницу с фильтрованными расходами
    }

    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable Long id, Principal principal, Model model) {
        Expense expense = (Expense) expenseService.getExpenseByIdAndUser(id, principal.getName());
        model.addAttribute("expense", expense);
        return "expense-detail"; // возвращаем страницу с деталями расхода
    }
    @GetMapping("/{id}")
    public Object getExpenseById(@PathVariable Long id, Principal principal) {
        return expenseService.getExpenseByIdAndUser(id, principal.getName());
    }
}