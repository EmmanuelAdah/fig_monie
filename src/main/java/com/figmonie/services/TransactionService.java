package com.figmonie.services;

import com.figmonie.dtos.request.TransactionRequest;
import com.figmonie.dtos.responses.TransactionResponse;

public interface TransactionService {

    TransactionResponse transfer(TransactionRequest request);
}
