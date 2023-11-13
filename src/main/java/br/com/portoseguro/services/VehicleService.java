package br.com.portoseguro.services;

import br.com.portoseguro.models.Client;
import br.com.portoseguro.models.Vehicle;
import br.com.portoseguro.repositories.VehicleRepostory;

import java.util.List;

public class VehicleService {
    private final VehicleRepostory vehicleRepostory;

    public VehicleService() {
        this.vehicleRepostory = new VehicleRepostory();
    }

    public void create (Vehicle vehicle) throws Exception {
        this.vehicleRepostory.save(vehicle);
    }
    public List<Vehicle> findAll () throws Exception {
        return this.vehicleRepostory.getAll();
    }
    public Vehicle findOneById (int id) throws Exception {
        return this.vehicleRepostory.getById(id);
    }
    public Vehicle update (int id, Vehicle vehicle) throws Exception {
        return this.vehicleRepostory.update(id, vehicle);
    }

    public void delete (int id) throws Exception {
        this.vehicleRepostory.delete(id);
    }
}
