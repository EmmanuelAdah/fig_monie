package com.figmonie.data.models;

import lombok.Getter;

@Getter
public enum BankCode {
    ACCESS("044"),
    GTBANK("058"),
    ZENITH("057"),
    UBA("033"),
    FIRSTBANK("011"),
    FIDELITY("070"),
    UNION("032");

    private final String code;

    BankCode(String code) {
        this.code = code;
    }
}
