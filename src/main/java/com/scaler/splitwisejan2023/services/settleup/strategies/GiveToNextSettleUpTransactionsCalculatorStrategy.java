package com.scaler.splitwisejan2023.services.settleup.strategies;

import com.scaler.splitwisejan2023.models.ExpenseOwingUser;
import com.scaler.splitwisejan2023.models.ExpensePayingUser;
import com.scaler.splitwisejan2023.models.User;
import com.scaler.splitwisejan2023.services.settleup.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("giveToNextSettleUpStrategy") //name of the bean.
public class GiveToNextSettleUpTransactionsCalculatorStrategy
    implements SettleUpTransactionsCalculatorStrategy {

    @Override
    public List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers,
                                             List<ExpenseOwingUser> expenseOwingUsers) {
        //expensePayingUsers -> UserExpensePaidBy
        //expenseOwingUsers -> UserExpenseHadToPay
        Map<User, Double> extraAmounts = new HashMap<>(); // User: Amount

//
//        A -> paid 100, B -> paid 60
//                A -> -20, B -> -80, C -> -60
//
//                        Map -> A : 0 + 100 - 20 = 80
//                                B : 0 + 60 - 80 = -20
//                                        C : -60 = -60
//
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
        //<A : -20> , <B : 80>, <C : 30>, <D : -90>.
        // A->B : -20
        //<A, 0>, <B: 60>, <C : 30>, <D : -90>.


        //<A, 20>, <B: 60>, <C : -30>, <D : -50>.

        List<Transaction> answer = new ArrayList<>();

        int n = entries.size();

        for (int i = 0; i < n - 1; ++i) {
            Transaction transaction = new Transaction();
            if (entries.get(i).getValue() < 0) { // HadToPay
                // ith user will pay to (i+1)st user
                transaction.setFrom(entries.get(i).getKey());
                transaction.setTo(entries.get(i + 1).getKey());
                transaction.setAmount(Math.abs(entries.get(i).getValue()));

                //Transaction will be from i to i+1 with amount x(amount of ith user).

                entries.get(i + 1).setValue(entries.get(i + 1).getValue() - Math.abs(entries.get(i).getValue()));
            } else if (entries.get(i).getValue() > 0) { // have paid extra
                transaction.setFrom(entries.get(i + 1).getKey());
                transaction.setTo(entries.get(i).getKey());
                transaction.setAmount(Math.abs(entries.get(i).getValue()));

                entries.get(i + 1).setValue(entries.get(i + 1).getValue() + Math.abs(entries.get(i).getValue()));
            }
        }

        return answer;
    }
}
