package br.com.portoseguro.services;

import br.com.portoseguro.models.Client;
import br.com.portoseguro.repositories.ClientRepository;

import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }
    public void create (Client client) throws Exception {
        this.clientRepository.save(client);
    }
    public List<Client> findAll () throws Exception {
        return this.clientRepository.getAll();
    }
    public Client findOneById (int id) throws Exception {
        return this.clientRepository.getById(id);
    }
    public Client update (int id, Client client) throws Exception {
        return this.clientRepository.update(id, client);
    }

    public void delete (int id) throws Exception {
        this.clientRepository.delete(id);
    }
}
