package com.example.expensetracker.controller;


import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseType;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/type/{type}")
    public List<Expense> getExpensesByType(@PathVariable ExpenseType type) {
        return expenseService.getExpensesByType(type);
    }
}
