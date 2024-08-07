package com.example.expensetracker.repository;

import com.example.expensetracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserUsername(String username);
    Optional<Income> findByIdAndUserUsername(Long id, String username);
    boolean existsByIdAndUserUsername(Long id, String username);
    void deleteByIdAndUserUsername(Long id, String username);
}
