package com.figmonie.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.figmonie.data.models.BankAccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.figmonie.utils.Mapper.mapDetails;

@Service
public class BankVerificationServiceImpl implements BankVerificationService {

    @Value("${paystack.secret}")
    private String secretKey;

    @Override
    public BankAccountDetails verifyAccount(String bankCode, String accountNumber){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secretKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://api.paystack.co/bank/resolve?account_number="
                + accountNumber + "&bank_code=" + bankCode;

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, JsonNode.class);

        if (!response.getBody().get("status").asBoolean()) {
            throw new IllegalArgumentException("Account verification failed");
        }

        JsonNode data = response.getBody().get("data");
        return mapDetails(data, bankCode);
    }
}
