package com.figmonie.dtos.request;

import lombok.Data;
import java.util.UUID;

@Data
public class AccountRequest {
    private String userId;
    private String accountNumber;
}
