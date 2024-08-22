package com.example.expensetracker.controller;

import com.example.expensetracker.model.Income;
import com.example.expensetracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public String getAllIncome(Principal principal, Model model) {
        List<Income> incomes = incomeService.getAllIncomesByUser(principal.getName());
        model.addAttribute("incomes", incomes);
        return "incomes"; // возвращаем страницу доходов
    }

    @GetMapping("/{id}")
    public String getIncomeById(@PathVariable Long id, Principal principal, Model model) {
        Income income = incomeService.getIncomeByIdAndUser(id, principal.getName());
        model.addAttribute("income", income);
        return "income-detail"; // возвращаем страницу с деталями дохода
    }
}

