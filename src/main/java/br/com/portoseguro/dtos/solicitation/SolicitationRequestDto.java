package br.com.portoseguro.dtos.solicitation;

import java.util.Date;

public record SolicitationRequestDto (
    char solicitationStatus,
    String userName,
    long solicitationId,
    long driverId,
    long towTruckId,
    long clientId,
    long policyId,
    Date startDate,
    Date endDate,
    Date registrationDate,
    String reason
) {}
