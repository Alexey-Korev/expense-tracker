package com.example.expensetracker.controller;

import com.example.expensetracker.model.Income;
import com.example.expensetracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeService.getAllIncome();
    }

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeService.saveIncome(income);
    }

    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }
}
