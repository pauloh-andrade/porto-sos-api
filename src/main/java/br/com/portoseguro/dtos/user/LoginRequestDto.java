package br.com.portoseguro.dtos.user;

import jakarta.validation.constraints.NotBlank;


public record LoginRequestDto(
        @NotBlank
        String phoneNumber,
        @NotBlank
        String password
) {
}
