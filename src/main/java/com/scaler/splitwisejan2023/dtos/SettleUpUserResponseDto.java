package com.scaler.splitwisejan2023.dtos;

import com.scaler.splitwisejan2023.services.settleup.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Transaction> transactions;
}
