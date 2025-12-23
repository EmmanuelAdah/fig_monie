package com.figmonie.dtos.request;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TransactionRequest {
    private UUID userId;
    private BigDecimal amount;
    private String recipientAccountNumber;
    private String recipientBank;
    private String currency;
    private String transactionPin;
}
