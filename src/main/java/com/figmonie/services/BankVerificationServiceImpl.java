package com.figmonie.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.figmonie.data.models.BankAccountDetails;
import com.figmonie.exceptions.ExternalServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static com.figmonie.utils.Mapper.mapDetails;

@Service
@RequiredArgsConstructor
public class BankVerificationServiceImpl implements BankVerificationService {
    private final WebClient webClient;

    @Value("${paystack.secret}")
    private String secretKey;

    @Override
    public BankAccountDetails verifyAccount(String bankCode, String accountNumber) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/bank/resolve")
                        .queryParam("account_number", accountNumber)
                        .queryParam("bank_code", bankCode)
                        .build())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + secretKey)
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class)
                                .map(ExternalServiceException::new))
                .bodyToMono(JsonNode.class)
                .<BankAccountDetails>handle((body, sink) -> {
                    if (!body.path("status").asBoolean(false)) {
                        sink.error(new IllegalArgumentException("Account verification failed"));
                        return;
                    }
                    sink.next(mapDetails(body.path("data"), bankCode));
                })
                .block();
    }

}
