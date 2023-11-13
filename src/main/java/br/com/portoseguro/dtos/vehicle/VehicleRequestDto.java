package br.com.portoseguro.dtos.vehicle;
import java.util.Date;

public record VehicleRequestDto (
        String vehicleType,
        String fuelType,
        char vehicleStatus,
        long renavamNumber,
        String plateNumber,
        String userName,
        String vehicleModel,
        long tankCapacity,
        long vehicleId,
        long requestId,
        long clientId,
        long policyId,
        Date lastMaintenanceDate,
        Date modelDate,
        Date startDate,
        Date endDate,
        Date manufactureDate,
        Date registrationDate,
        String vehicleDescription,
        long cargoCapacity,
        long motorCapacity,
        long motorPower
) {
}