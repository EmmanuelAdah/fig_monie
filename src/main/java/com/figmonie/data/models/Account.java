package com.figmonie.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountNumber;
    private BigDecimal balance;
    private Saving savings;
    private String transactionPin;

    private List<Transaction> transactions;
}
