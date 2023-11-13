package br.com.portoseguro.models;

import br.com.portoseguro.dtos.vehicle.VehicleRequestDto;

import java.util.Date;

public class Vehicle {
    private long id;
    private String vehicleType;
    private String fuelType;
    private char vehicleStatus;
    private long renavamNumber;
    private String plateNumber;
    private String userName;
    private String vehicleModel;
    private long tankCapacity;
    private long requestId;
    private long clientId;
    private long policyId;
    private Date lastMaintenanceDate;
    private Date modelDate;
    private Date startDate;
    private Date endDate;
    private Date manufactureDate;
    private Date registrationDate;
    private String vehicleDescription;
    private long cargoCapacity;
    private long motorCapacity;
    private long motorPower;

    public Vehicle(String vehicleType, String fuelType, char vehicleStatus, long renavamNumber, String plateNumber, String userName, String vehicleModel, long tankCapacity, long requestId, long clientId, long policyId, Date lastMaintenanceDate, Date modelDate, Date startDate, Date endDate, Date manufactureDate, Date registrationDate, String vehicleDescription, long cargoCapacity, long motorCapacity, long motorPower) {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.vehicleStatus = vehicleStatus;
        this.renavamNumber = renavamNumber;
        this.plateNumber = plateNumber;
        this.userName = userName;
        this.vehicleModel = vehicleModel;
        this.tankCapacity = tankCapacity;
        this.requestId = requestId;
        this.clientId = clientId;
        this.policyId = policyId;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.modelDate = modelDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.manufactureDate = manufactureDate;
        this.registrationDate = registrationDate;
        this.vehicleDescription = vehicleDescription;
        this.cargoCapacity = cargoCapacity;
        this.motorCapacity = motorCapacity;
        this.motorPower = motorPower;
    }

    public Vehicle(VehicleRequestDto vehicle) {
        this.vehicleType = vehicle.vehicleType();
        this.fuelType = vehicle.fuelType();
        this.vehicleStatus = vehicle.vehicleStatus();
        this.renavamNumber = vehicle.renavamNumber();
        this.plateNumber = vehicle.plateNumber();
        this.userName = vehicle.userName();
        this.vehicleModel = vehicle.vehicleModel();
        this.tankCapacity = vehicle.tankCapacity();
        this.requestId = vehicle.requestId();
        this.clientId = vehicle.clientId();
        this.policyId = vehicle.policyId();
        this.lastMaintenanceDate = vehicle.lastMaintenanceDate();
        this.modelDate = vehicle.modelDate();
        this.startDate = vehicle.startDate();
        this.endDate = vehicle.endDate();
        this.manufactureDate = vehicle.manufactureDate();
        this.registrationDate = vehicle.registrationDate();
        this.vehicleDescription = vehicle.vehicleDescription();
        this.cargoCapacity = vehicle.cargoCapacity();
        this.motorCapacity = vehicle.motorCapacity();
        this.motorPower = vehicle.motorPower();
    }

    public Vehicle(String vehicleType, String fuelType, char vehicleStatus, long renavamNumber, String plateNumber, String userName, String vehicleModel, long tankCapacity, long vehicleId, long requestId, long clientId, long policyId, java.sql.Date lastMaintenanceDate, java.sql.Date modelDate, java.sql.Date startDate, java.sql.Date endDate, java.sql.Date manufactureDate, java.sql.Date registrationDate, String vehicleDescription, long cargoCapacity, long motorCapacity, long motorPower) {
    }

    public Vehicle() {

    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public char getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(char vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public long getRenavamNumber() {
        return renavamNumber;
    }

    public void setRenavamNumber(long renavamNumber) {
        this.renavamNumber = renavamNumber;
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

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public long getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(long tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
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

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public Date getModelDate() {
        return modelDate;
    }

    public void setModelDate(Date modelDate) {
        this.modelDate = modelDate;
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

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public long getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(long cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public long getMotorCapacity() {
        return motorCapacity;
    }

    public void setMotorCapacity(long motorCapacity) {
        this.motorCapacity = motorCapacity;
    }

    public long getMotorPower() {
        return motorPower;
    }

    public void setMotorPower(long motorPower) {
        this.motorPower = motorPower;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
