package com.figmonie.data.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountNumber;
    private BigDecimal balance;
    private Saving savings;
    private String transactionPin;

    private List<Transaction> transactions;
}
