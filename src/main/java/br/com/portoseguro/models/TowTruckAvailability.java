package br.com.portoseguro.models;

import br.com.portoseguro.dtos.towTruckAvailability.TowTruckAvailabilityRequestDto;

import java.util.Date;

public class TowTruckAvailability {
    private long id;
    private String availabilityStatus;
    private String plateNumber;
    private String userName;
    private long towTruckId;
    private Date registrationDate;
    private double cargoCapacity;

    public TowTruckAvailability(long id, String availabilityStatus, String plateNumber, String userName, long towTruckId, Date registrationDate, double cargoCapacity) {
        this.id = id;
        this.availabilityStatus = availabilityStatus;
        this.plateNumber = plateNumber;
        this.userName = userName;
        this.towTruckId = towTruckId;
        this.registrationDate = registrationDate;
        this.cargoCapacity = cargoCapacity;
    }

    public TowTruckAvailability(TowTruckAvailabilityRequestDto towTruckAvailability) {
        this.availabilityStatus = towTruckAvailability.availabilityStatus();
        this.plateNumber = towTruckAvailability.plateNumber();
        this.userName = towTruckAvailability.userName();
        this.towTruckId = towTruckAvailability.towTruckId();
        this.registrationDate = towTruckAvailability.registrationDate();
        this.cargoCapacity = towTruckAvailability.cargoCapacity();
    }

    public TowTruckAvailability() { }

    public TowTruckAvailability(int id, String plateNumber, String userName, String availabilityStatus, java.sql.Date registrationDate, double cargaPeso) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTowTruckId() {
        return towTruckId;
    }

    public void setTowTruckId(long towTruckId) {
        this.towTruckId = towTruckId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
