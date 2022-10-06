package com.sam.savetravelscore.services;

import com.sam.savetravelscore.models.Expense;
import com.sam.savetravelscore.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public void createExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> allExpenses() {
        return expenseRepository.findAll();

    }

    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }

    public void updateExpense(Expense expense) {
//        Expense e = findExpense(expense.getId());
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
