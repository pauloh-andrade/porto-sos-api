package br.com.portoseguro.dtos.address;

import java.util.Date;

public record AddressRequestDto (
        long logradouroNumber,
        String userName,
        long logradouroId,
        long clientId,
        Date startDate,
        Date endDate,
        Date registrationDate,
        String pontoReferencia,
        String complementoNumero
) {
}