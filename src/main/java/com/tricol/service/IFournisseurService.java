package com.tricol.service;

import com.tricol.model.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface IFournisseurService {

    List<Fournisseur> findAll();

    List<Fournisseur> findAllSortedBySociete();

    Optional<Fournisseur> findById(Long id);

    Fournisseur save(Fournisseur fournisseur);

    Fournisseur update(Long id, Fournisseur fournisseur);

    void deleteById(Long id);

    List<Fournisseur> searchBySociete(String societePart);

    List<Fournisseur> findByEmailDomain(String domain);
}
