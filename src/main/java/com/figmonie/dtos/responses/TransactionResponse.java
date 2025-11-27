package com.figmonie.dtos.responses;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime date;
}
