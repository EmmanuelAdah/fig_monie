package com.figmonie.data.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;
    private BigDecimal amount;
    private boolean transactionStatus;
    private String recipientAccountNumber;
    private String recipientBank;

    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
