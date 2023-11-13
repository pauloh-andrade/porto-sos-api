package br.com.portoseguro.dtos.towTruckOperator;

public record TowTruckOperatorRequestDto(
        long id,
        String driverStatus,
        long phoneNumber,
        String driverName
) {
}
