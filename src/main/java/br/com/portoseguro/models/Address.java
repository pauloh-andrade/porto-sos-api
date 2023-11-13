package br.com.portoseguro.models;

import br.com.portoseguro.dtos.address.AddressRequestDto;

import java.util.Date;

public class Address {
    private long id;
    private long logradouroNumber;
    private String userName;
    private long logradouroId;
    private long clientId;
    private Date startDate;
    private Date endDate;
    private Date registrationDate;
    private String pontoReferencia;
    private String complementoNumero;

    public Address(long id, long logradouroNumber, String userName, long logradouroId, long clientId, Date startDate, Date endDate, Date registrationDate, String pontoReferencia, String complementoNumero) {
        this.id = id;
        this.logradouroNumber = logradouroNumber;
        this.userName = userName;
        this.logradouroId = logradouroId;
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationDate = registrationDate;
        this.pontoReferencia = pontoReferencia;
        this.complementoNumero = complementoNumero;
    }

    public Address(AddressRequestDto addressRequestDto) {
        this.logradouroNumber = addressRequestDto.logradouroNumber();
        this.userName = addressRequestDto.userName();
        this.logradouroId = addressRequestDto.logradouroId();
        this.clientId = addressRequestDto.clientId();
        this.startDate = addressRequestDto.startDate();
        this.endDate = addressRequestDto.endDate();
        this.registrationDate = addressRequestDto.registrationDate();
        this.pontoReferencia = addressRequestDto.pontoReferencia();
        this.complementoNumero = addressRequestDto.complementoNumero();
    }

    public Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLogradouroNumber() {
        return logradouroNumber;
    }

    public void setLogradouroNumber(long logradouroNumber) {
        this.logradouroNumber = logradouroNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getLogradouroId() {
        return logradouroId;
    }

    public void setLogradouroId(long logradouroId) {
        this.logradouroId = logradouroId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getComplementoNumero() {
        return complementoNumero;
    }

    public void setComplementoNumero(String complementoNumero) {
        this.complementoNumero = complementoNumero;
    }
}
