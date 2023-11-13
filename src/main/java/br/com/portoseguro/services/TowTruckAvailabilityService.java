package br.com.portoseguro.services;

import br.com.portoseguro.models.TowTruckAvailability;
import br.com.portoseguro.repositories.TowTruckAvailabilityRepository;

import java.util.List;

public class TowTruckAvailabilityService {
    private final TowTruckAvailabilityRepository towTruckAvailabilityRepository;

    public TowTruckAvailabilityService() {
        this.towTruckAvailabilityRepository = new TowTruckAvailabilityRepository();
    }

    public void create(TowTruckAvailability towTruckAvailability) throws Exception {
        this.towTruckAvailabilityRepository.save(towTruckAvailability);
    }

    public List<TowTruckAvailability> findAll() throws Exception {
        return this.towTruckAvailabilityRepository.getAll();
    }

    public TowTruckAvailability findOneById(int id) throws Exception {
        return this.towTruckAvailabilityRepository.getById(id);
    }

    public TowTruckAvailability update(int id, TowTruckAvailability towTruckAvailability) throws Exception {
        return this.towTruckAvailabilityRepository.update(id, towTruckAvailability);
    }

    public void delete(int id) throws Exception {
        this.towTruckAvailabilityRepository.delete(id);
    }
}