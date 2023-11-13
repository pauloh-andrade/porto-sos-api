package br.com.portoseguro.dtos.towTruckAvailability;

import java.util.Date;

public record TowTruckAvailabilityRequestDto(
        String availabilityStatus,
        String plateNumber,
        String userName,
        long towTruckId,
        Date registrationDate,
        double cargoCapacity
) {

}
