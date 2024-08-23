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

    @PostMapping
    public String createExpense(@ModelAttribute Expense expense, Principal principal) {
        expenseService.saveExpense(expense, principal.getName());
        return "redirect:/expenses";
    }

    @GetMapping
    public String getAllExpenses(Model model, Principal principal) {
        List<Expense> expenses = expenseService.getAllExpensesByUser(principal.getName());
        model.addAttribute("expenses", expenses);
        return "expenses"; // Возвращаем имя шаблона
    }

    @GetMapping("/type/{type}")
    public String getExpensesByType(@PathVariable ExpenseType type, Model model, Principal principal) {
        List<Expense> expenses = expenseService.getExpensesByTypeAndUser(type, principal.getName());
        model.addAttribute("expenses", expenses);
        return "expenses"; // Возвращаем имя шаблона
    }

    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable Long id, Model model, Principal principal) {
        Expense expense = (Expense) expenseService.getExpenseByIdAndUser(id, principal.getName());
        model.addAttribute("expense", expense);
        return "expense-details"; // Возвращаем имя шаблона
    }

    @PutMapping("/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute Expense expense, Principal principal) {
        expenseService.updateExpense(id, expense, principal.getName());
        return "redirect:/expenses";
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id, Principal principal) {
        expenseService.deleteExpense(id, principal.getName());
        return "redirect:/expenses";
    }
}