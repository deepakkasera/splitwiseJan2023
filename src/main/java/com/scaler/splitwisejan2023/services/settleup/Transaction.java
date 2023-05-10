package com.scaler.splitwisejan2023.services.settleup;

import com.scaler.splitwisejan2023.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private double amount;
}
