package com.figmonie.dtos.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    private String userId;
    private BigDecimal amount;
    private String recipientAccountNumber;
    private String recipientBank;
    private String currency;
    private String transactionPin;
}
