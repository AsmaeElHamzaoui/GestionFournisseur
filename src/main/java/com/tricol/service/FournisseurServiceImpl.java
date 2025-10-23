package com.tricol.service;

import com.tricol.model.Fournisseur;
import com.tricol.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FournisseurServiceImpl implements IFournisseurService {

    private final FournisseurRepository repository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Fournisseur> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Fournisseur> findAllSortedBySociete() {
        return repository.findAllByOrderBySocieteAsc();
    }

    @Override
    public Optional<Fournisseur> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Fournisseur save(Fournisseur fournisseur) {
        return repository.save(fournisseur);
    }

    @Override
    public Fournisseur update(Long id, Fournisseur fournisseur) {
        return repository.findById(id).map(existing -> {
            existing.setSociete(fournisseur.getSociete());
            existing.setAdresse(fournisseur.getAdresse());
            existing.setContact(fournisseur.getContact());
            existing.setEmail(fournisseur.getEmail());
            existing.setTelephone(fournisseur.getTelephone());
            existing.setVille(fournisseur.getVille());
            existing.setIce(fournisseur.getIce());
            return repository.save(existing);
        }).orElseGet(() -> {
            fournisseur.setId(id);
            return repository.save(fournisseur);
        });
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Fournisseur> searchBySociete(String societePart) {
        return repository.findBySocieteContainingIgnoreCase(societePart);
    }

    @Override
    public List<Fournisseur> findByEmailDomain(String domain) {
        return repository.findByEmailEndingWith(domain);
    }
}
