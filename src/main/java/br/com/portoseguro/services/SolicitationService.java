package br.com.portoseguro.services;

import br.com.portoseguro.models.Solicitation;
import br.com.portoseguro.repositories.SolicitationRepository;

import java.util.List;

public class SolicitationService {
    private final SolicitationRepository solicitationRepository;

    public SolicitationService() {
        this.solicitationRepository = new SolicitationRepository();
    }

    public void create (Solicitation solicitation) throws Exception {
        this.solicitationRepository.save(solicitation);
    }
    public List<Solicitation> findAll () throws Exception {
        return this.solicitationRepository.getAll();
    }
    public Solicitation findOneById (int id) throws Exception {
        return this.solicitationRepository.getById(id);
    }
    public Solicitation update (int id, Solicitation solicitation) throws Exception {
        return this.solicitationRepository.update(id, solicitation);
    }

    public void delete (int id) throws Exception {
        this.solicitationRepository.delete(id);
    }
}
