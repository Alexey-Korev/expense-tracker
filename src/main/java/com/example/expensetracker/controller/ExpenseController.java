package com.example.expensetracker.controller;


import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseType;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense, Principal principal) {
        return expenseService.saveExpense(expense, principal.getName());
    }

    @GetMapping
    public List<Expense> getAllExpenses(Principal principal) {
        return expenseService.getAllExpensesByUser(principal.getName());
    }

    @GetMapping("/type/{type}")
    public List<Expense> getExpensesByType(@PathVariable ExpenseType type, Principal principal) {
        return expenseService.getExpensesByTypeAndUser(type, principal.getName());
    }

    @GetMapping("/{id}")
    public Object getExpenseById(@PathVariable Long id, Principal principal) {
        return expenseService.getExpenseByIdAndUser(id, principal.getName());
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense, Principal principal) {
        return expenseService.updateExpense(id, expense, principal.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id, Principal principal) {
        expenseService.deleteExpense(id, principal.getName());
    }
}
