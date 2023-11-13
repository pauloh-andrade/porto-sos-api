package br.com.portoseguro.services;

import br.com.portoseguro.models.TowTruckOperator;
import br.com.portoseguro.repositories.TowTruckOperatorRepository;

import java.util.List;

public class TowTruckOperatorService {
    private final TowTruckOperatorRepository towTruckOperatorRepository;

    public TowTruckOperatorService() {
        this.towTruckOperatorRepository = new TowTruckOperatorRepository();
    }

    public void create(TowTruckOperator towTruckOperator) throws Exception {
        this.towTruckOperatorRepository.save(towTruckOperator);
    }

    public List<TowTruckOperator> findAll() throws Exception {
        return this.towTruckOperatorRepository.getAll();
    }

    public TowTruckOperator findOneById(int id) throws Exception {
        return this.towTruckOperatorRepository.getById(id);
    }

    public TowTruckOperator update(int id, TowTruckOperator towTruckOperator) throws Exception {
        return this.towTruckOperatorRepository.update(id, towTruckOperator);
    }

    public void delete(int id) throws Exception {
        this.towTruckOperatorRepository.delete(id);
    }
}
