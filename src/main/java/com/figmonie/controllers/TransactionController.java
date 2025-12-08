package com.figmonie.controllers;

import com.figmonie.dtos.request.TransactionRequest;
import com.figmonie.dtos.responses.TransactionResponse;
import com.figmonie.services.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> transfer(TransactionRequest request){
        return ResponseEntity.ok(transactionService.transfer(request));
    }
}
