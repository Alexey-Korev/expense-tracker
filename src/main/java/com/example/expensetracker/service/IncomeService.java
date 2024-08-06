package com.example.expensetracker.service;

import com.example.expensetracker.model.Income;
import com.example.expensetracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
