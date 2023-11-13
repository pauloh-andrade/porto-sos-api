package br.com.portoseguro.models;

import br.com.portoseguro.dtos.client.ClientRequestDto;

public class Client extends User{
    private int id;
    private String cpf;
    private String rg;


    public Client(ClientRequestDto client) {
        super(client.name(), client.phoneNumber(), client.emailAddress(), client.password());
        this.cpf = client.cpf();
        this.rg = client.rg();
    }

    public Client(int id, String name, String phoneNumber, String emailAddress, String password, String cpf, String rg) {
        super(name, phoneNumber, emailAddress, password);
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Client() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
