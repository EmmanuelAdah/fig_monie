package com.figmonie.services;

import com.figmonie.data.models.BankAccountDetails;

public interface BankVerificationService {
    BankAccountDetails verifyAccount(String bankCode, String accountNumber);
}
