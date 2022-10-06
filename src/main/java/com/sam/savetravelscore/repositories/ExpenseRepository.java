package com.sam.savetravelscore.repositories;

import com.sam.savetravelscore.models.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll();


}
