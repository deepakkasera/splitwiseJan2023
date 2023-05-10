package com.scaler.splitwisejan2023.services.settleup.strategies;

import com.scaler.splitwisejan2023.models.ExpenseOwingUser;
import com.scaler.splitwisejan2023.models.ExpensePayingUser;
import com.scaler.splitwisejan2023.models.User;
import com.scaler.splitwisejan2023.services.settleup.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("minMaxSettleUp")
public class MinMaxSettleUpTransactionsCalculatorStrategy implements SettleUpTransactionsCalculatorStrategy {
    @Override
    public List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers, List<ExpenseOwingUser> expenseOwingUsers) {
        Map<User, Double> extraAmounts = new HashMap<>(); // User: Amount

        for (ExpensePayingUser expensePayingUser: expensePayingUsers) {
            if (!extraAmounts.containsKey(expensePayingUser.getUser())) {
                extraAmounts.put(expensePayingUser.getUser(), 0.);
            }

            extraAmounts.put(
                    expensePayingUser.getUser(),
                    extraAmounts.get(expensePayingUser.getUser()) + expensePayingUser.getAmount()
            );
        }

        for (ExpenseOwingUser expenseOwingUser: expenseOwingUsers) {
            if (!extraAmounts.containsKey(expenseOwingUser.getUser())) {
                extraAmounts.put(expenseOwingUser.getUser(), 0.);
            }

            extraAmounts.put(
                    expenseOwingUser.getUser(),
                    extraAmounts.get(expenseOwingUser.getUser()) - expenseOwingUser.getAmount()
            );
        }

        List<Map.Entry<User, Double>> entries = new ArrayList<>(extraAmounts.entrySet());
        Queue<User> positiveQueue = new ArrayDeque<>(); // MAX HEAP.
        Queue<User> negativeQueue = new ArrayDeque<>(); // MIN HEAP

        //Iterate over list of paying users -> positiveQueue
        //Iterate over list of users paid -> negativeQueue

        while (!positiveQueue.isEmpty() && !negativeQueue.isEmpty()) {
            //
        }

        List<Transaction> answer = new ArrayList<>();

        return answer;
    }
}
