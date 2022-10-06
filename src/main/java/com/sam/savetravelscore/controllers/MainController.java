package com.sam.savetravelscore.controllers;

import com.sam.savetravelscore.models.Expense;
import com.sam.savetravelscore.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller()
public class MainController {

    @Autowired
    ExpenseService expenseService;
// ! CREATE and READ ALL
    @GetMapping("/")
    public String index(@ModelAttribute("expense") Expense expense, Model model){
        List<Expense> expenses= expenseService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }

    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Expense> expenses= expenseService.allExpenses();
            model.addAttribute("expenses", expenses);
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }

    }
// ! READ ONE//////////////////////
    @GetMapping("/expenses/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }
///UPDATE////////////////////////

@GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
    Expense expense = expenseService.findExpense(id);
    model.addAttribute("expense", expense);
    return "edit.jsp";
}

    @PutMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long id){
        System.out.println(expense.getId());
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/";
        }
    }
////DELETE//////////////////////////////
        @RequestMapping("/expenses/{id}")
        public String destroy(@PathVariable("id") Long id) {
            expenseService.deleteExpense(id);
            return "redirect:/";
        }
    }

