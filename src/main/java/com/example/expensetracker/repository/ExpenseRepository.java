package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserUsername(String username);
    List<Expense> findByTypeAndUserUsername(ExpenseType type, String username);
    boolean existsByIdAndUserUsername(Long id, String username);
    void deleteByIdAndUserUsername(Long id, String username);

    Optional<Object> findByIdAndUserUsername(Long id, String username);
}

