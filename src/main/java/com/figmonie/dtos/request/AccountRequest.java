package com.figmonie.dtos.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String userId;
    private String accountNumber;
}
