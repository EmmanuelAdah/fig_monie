package com.figmonie.controllers;

import com.figmonie.dtos.request.TransactionRequest;
import com.figmonie.dtos.responses.TransactionResponse;
import com.figmonie.services.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    public ResponseEntity<TransactionResponse> saveTransaction(TransactionRequest request){
        return ResponseEntity.ok(new TransactionResponse());
    }
}
