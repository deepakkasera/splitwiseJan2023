package com.scaler.splitwisejan2023.services.settleup;

import com.scaler.splitwisejan2023.models.*;
import com.scaler.splitwisejan2023.repositories.ExpenseOwingUserRepository;
import com.scaler.splitwisejan2023.repositories.ExpensePayingUserRepository;
import com.scaler.splitwisejan2023.repositories.GroupRepository;
import com.scaler.splitwisejan2023.services.settleup.strategies.SettleUpTransactionsCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    @Autowired
    @Qualifier("giveToNextSettleUpStrategy")
    private SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy;

    private GroupRepository groupRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;

    @Autowired
    public SettleUpService(SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy) {
        this.settleUpTransactionsCalculatorStrategy = settleUpTransactionsCalculatorStrategy;
    }

    public List<Transaction> settleUpUser(Long userId) {
        return null;
    }

    // Algo:
    // settleUp(group_id) {
    //    1. Get all epu and eou for the group
    //    2. Do calculation to compute the transaction
    // }
    public List<Transaction> settleUpGroup(Long groupId) {
        // All the DB related code will go into repositories.
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (!groupOptional.isPresent()) {
            // throw some exception
            System.out.println("No group with that id");
        }

        Group group = groupOptional.get();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>(); // UserExpensePaidBy
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>(); // UserExpenseHadToPay

        for (Expense expense: group.getExpenses()) { //List of all the expenses in a particular group.
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
        }

        //From the list of expenses, we need to find out all the UserExpensePaidBy and UserExpenseHadToPay.
        return settleUpTransactionsCalculatorStrategy.getTransactions(
                expensePayingUsers,
                expenseOwingUsers
        );
    }
}


//@Qualifier.
// StrategyInterface si;
// Class A implements StrategyInterface { ........... }
// Class B implements StrategyInterface { ........... }