package br.com.portoseguro.models;

public class Modal {
    private int id;
    private String name;
    private ModalType type;

    public Modal(String name, ModalType type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModalType getType() {
        return type;
    }

    public void setType(ModalType type) {
        this.type = type;
    }
}
