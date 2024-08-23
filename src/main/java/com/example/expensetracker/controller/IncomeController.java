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

    @PostMapping
    public String createIncome(@ModelAttribute Income income, Principal principal) {
        incomeService.saveIncome(income, principal.getName());
        return "redirect:/incomes";
    }

    @GetMapping
    public String getAllIncome(Model model, Principal principal) {
        List<Income> incomes = incomeService.getAllIncomesByUser(principal.getName());
        model.addAttribute("incomes", incomes);
        return "incomes"; // Возвращаем имя шаблона
    }

    @GetMapping("/{id}")
    public String getIncomeById(@PathVariable Long id, Model model, Principal principal) {
        Income income = incomeService.getIncomeByIdAndUser(id, principal.getName());
        model.addAttribute("income", income);
        return "income-details"; // Возвращаем имя шаблона
    }

    @PutMapping("/{id}")
    public String updateIncome(@PathVariable Long id, @ModelAttribute Income income, Principal principal) {
        incomeService.updateIncome(id, income, principal.getName());
        return "redirect:/incomes";
    }

    @DeleteMapping("/{id}")
    public String deleteIncome(@PathVariable Long id, Principal principal) {
        incomeService.deleteIncome(id, principal.getName());
        return "redirect:/incomes";
    }
}

