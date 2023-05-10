package com.scaler.splitwisejan2023.services.settleup.strategies;

import com.scaler.splitwisejan2023.models.ExpenseOwingUser;
import com.scaler.splitwisejan2023.models.ExpensePayingUser;
import com.scaler.splitwisejan2023.services.settleup.Transaction;

import java.util.List;

public interface SettleUpTransactionsCalculatorStrategy {
    //Strategy Design Pattern

    //This will return the list of transactions that needs to be performed in order to settle up all the
    // given expenses.
    List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers,
                                      List<ExpenseOwingUser> expenseOwingUsers);
}
