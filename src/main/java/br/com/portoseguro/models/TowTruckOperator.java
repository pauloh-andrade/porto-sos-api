package br.com.portoseguro.models;

import br.com.portoseguro.dtos.towTruckOperator.TowTruckOperatorRequestDto;

public class TowTruckOperator {
    private long id;
    private String driverStatus;
    private long phoneNumber;
    private String driverName;

    public TowTruckOperator(long id, String driverStatus, long phoneNumber, String driverName) {
        this.id = id;
        this.driverStatus = driverStatus;
        this.phoneNumber = phoneNumber;
        this.driverName = driverName;
    }

    public TowTruckOperator(TowTruckOperatorRequestDto towTruckOperator) {
        this.driverStatus = towTruckOperator.driverStatus();
        this.phoneNumber = towTruckOperator.phoneNumber();
        this.driverName = towTruckOperator.driverName();
        this.id = towTruckOperator.id();
    }

    public TowTruckOperator() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
