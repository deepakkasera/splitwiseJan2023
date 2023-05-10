package com.scaler.splitwisejan2023.repositories;

import com.scaler.splitwisejan2023.models.Expense;
import com.scaler.splitwisejan2023.models.ExpenseOwingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseOwingUserRepository
extends JpaRepository<ExpenseOwingUser, Long> {
    List<ExpenseOwingUser> findAllByExpense(Expense expense); // List<UserExpenseHadToPay>
}
