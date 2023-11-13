package br.com.portoseguro.models;

import br.com.portoseguro.dtos.solicitation.SolicitationRequestDto;

import java.util.Date;

public class Solicitation {
    private char requestStatus;
    private String userName;
    private long solicitationId;
    private long driverId;
    private long towTruckId;
    private long clientId;
    private long policyId;
    private Date startDate;
    private Date endDate;
    private Date registrationDate;
    private String reasonDescription;

    public Solicitation(char requestStatus, String userName, long solicitationId, long driverId, long towTruckId, long clientId, long policyId, Date startDate, Date endDate, Date registrationDate, String reasonDescription) {
        this.requestStatus = requestStatus;
        this.userName = userName;
        this.solicitationId = solicitationId;
        this.driverId = driverId;
        this.towTruckId = towTruckId;
        this.clientId = clientId;
        this.policyId = policyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationDate = registrationDate;
        this.reasonDescription = reasonDescription;
    }

    public Solicitation(SolicitationRequestDto solicitation) {
        this.requestStatus = solicitation.solicitationStatus();
        this.userName = solicitation.userName();
        this.solicitationId = solicitation.solicitationId();
        this.driverId = solicitation.driverId();
        this.towTruckId = solicitation.towTruckId();
        this.clientId = solicitation.clientId();
        this.policyId = solicitation.policyId();
        this.startDate = solicitation.startDate();
        this.endDate = solicitation.endDate();
        this.registrationDate = solicitation.registrationDate();
        this.reasonDescription = solicitation.reason();

    }

    public Solicitation() {
    }

    public char getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(char requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getSolicitationId() {
        return solicitationId;
    }

    public void setSolicitationId(long solicitationId) {
        this.solicitationId = solicitationId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public long getTowTruckId() {
        return towTruckId;
    }

    public void setTowTruckId(long towTruckId) {
        this.towTruckId = towTruckId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }
}
