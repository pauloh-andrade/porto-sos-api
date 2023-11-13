package br.com.portoseguro.models;

public class Administrator extends User {
    private int id;
    private int permission;

    public Administrator(String name, String phoneNumber, String emailAddress, String password, int permission) {
        super(name, phoneNumber, emailAddress, password);
        this.permission = permission;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
