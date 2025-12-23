package com.figmonie.dtos.request;

import lombok.Data;
import java.util.UUID;

@Data
public class AccountRequest {
    private UUID userId;
    private String accountNumber;
}
