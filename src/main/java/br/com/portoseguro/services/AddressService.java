package br.com.portoseguro.services;

import br.com.portoseguro.models.Address;
import br.com.portoseguro.repositories.AddressRepository;

import java.util.List;

public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService() {
        this.addressRepository = new AddressRepository();
    }

    public void create(Address address) throws Exception {
        this.addressRepository.save(address);
    }

    public List<Address> findAll() throws Exception {
        return this.addressRepository.getAll();
    }

    public Address findOneById(int id) throws Exception {
        return this.addressRepository.getById(id);
    }

    public Address update(int id, Address address) throws Exception {
        return this.addressRepository.update(id, address);
    }

    public void delete(int id) throws Exception {
        this.addressRepository.delete(id);
    }
}
