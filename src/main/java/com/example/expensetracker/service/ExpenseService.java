package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseType;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpensesByUser(String username) {
        return expenseRepository.findByUserUsername(username);
    }

    public Expense saveExpense(Expense expense, String username) {
        expense.setUserUsername(username);
        return expenseRepository.save(expense);
    }

    public Object getExpenseByIdAndUser(Long id, String username) {
        return expenseRepository.findByIdAndUserUsername(id, username).orElse(null);
    }

    public Expense updateExpense(Long id, Expense expense, String username) {
        if (expenseRepository.existsByIdAndUserUsername(id, username)) {
            expense.setId(id);
            expense.setUserUsername(username);
            return expenseRepository.save(expense);
        } else {
            return null;
        }
    }

    public void deleteExpense(Long id, String username) {
        expenseRepository.deleteByIdAndUserUsername(id, username);
    }

    public List<Expense> getExpensesByTypeAndUser(ExpenseType type, String username) {
        return expenseRepository.findByTypeAndUserUsername(type, username);
    }
}
