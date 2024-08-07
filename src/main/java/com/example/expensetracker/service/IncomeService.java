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

    public List<Income> getAllIncomesByUser(String username) {
        return incomeRepository.findByUserUsername(username);
    }

    public Income saveIncome(Income income, String username) {
        income.setUserUsername(username);
        return incomeRepository.save(income);
    }

    public Income getIncomeByIdAndUser(Long id, String username) {
        return incomeRepository.findByIdAndUserUsername(id, username).orElse(null);
    }

    public Income updateIncome(Long id, Income income, String username) {
        if (incomeRepository.existsByIdAndUserUsername(id, username)) {
            income.setId(id);
            income.setUserUsername(username);
            return incomeRepository.save(income);
        } else {
            return null;
        }
    }

    public void deleteIncome(Long id, String username) {
        incomeRepository.deleteByIdAndUserUsername(id, username);
    }
}
