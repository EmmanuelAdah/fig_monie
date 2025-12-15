package com.figmonie.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.figmonie.data.models.*;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.request.TransactionRequest;
import com.figmonie.dtos.responses.TransactionResponse;
import com.figmonie.dtos.responses.UserResponse;

public class Mapper {

    public static User map(RegisterRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.valueOf(request.getRole()
                .toUpperCase()
                .trim()));

        return user;
    }

    public static UserResponse map(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    public static Transaction map(User user, TransactionRequest request, String type) {
        Transaction transaction = new Transaction();
        transaction.setUserId(user.getId());
        transaction.setRecipientAccountNumber(request.getRecipientAccountNumber());
        transaction.setRecipientBank(request.getRecipientBank());
        transaction.setAmount(request.getAmount());
        boolean transactionStatus = false;
        transaction.setTransactionStatus(!transactionStatus);
        transaction.setType(TransactionType.valueOf(type));

        return transaction;
    }

    public static TransactionResponse mapResponse(User user, Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setAmount(transaction.getAmount());
        response.setRecipientAccountNumber(transaction.getRecipientAccountNumber());
        response.setRecipientBank(transaction.getRecipientBank());
        response.setBalance(user.getAccount().getBalance());
        return response;
    }

    public static BankAccountDetails mapDetails(JsonNode data, String bankCode) {
        BankAccountDetails details = new BankAccountDetails();
        details.setAccountName(data.get("account_name").asText());
        details.setAccountNumber(data.get("account_number").asText());
        details.setBankCode(bankCode);
        return details;
    }
}
