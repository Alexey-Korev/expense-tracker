package com.example.expensetracker.controller;

import com.example.expensetracker.model.Income;
import com.example.expensetracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/incomes")
public class APIIncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public Income createIncome(@RequestBody Income income, Principal principal) {
        return incomeService.saveIncome(income, principal.getName());
    }

    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable Long id, @RequestBody Income income, Principal principal) {
        return incomeService.updateIncome(id, income, principal.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id, Principal principal) {
        incomeService.deleteIncome(id, principal.getName());
    }
}

