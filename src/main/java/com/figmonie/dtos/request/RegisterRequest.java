package com.figmonie.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Firstname must not be empty")
    private String firstname;

    @NotBlank(message = "Lastname must not be empty")
    private String lastname;

    @NotBlank
    private String email;

    @NotBlank
    private String role;

    @NotBlank
    @Size(min = 6, max = 20, message = "Password must be between {min} and {max}")
    private String password;
}
