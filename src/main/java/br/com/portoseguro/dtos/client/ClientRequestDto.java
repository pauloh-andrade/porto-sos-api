package br.com.portoseguro.dtos.client;

import jakarta.validation.constraints.*;

public record ClientRequestDto(
        @NotBlank
        @Size(max = 10)
        String name,
        @NotBlank
        String phoneNumber,
        @NotBlank
        @Email
        String emailAddress,
        @NotBlank
        String password,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        @Pattern(regexp = "\\d{7,9}")
        String rg
) {
}


