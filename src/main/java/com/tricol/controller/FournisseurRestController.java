package com.tricol.controller;

import com.tricol.model.Fournisseur;
import com.tricol.service.IFournisseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fournisseurs")
public class FournisseurRestController {

    private final IFournisseurService service;


    public FournisseurRestController(IFournisseurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fournisseur> getAll() {
        return service.findAllSortedBySociete();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable("id") Long id) {
        Optional<Fournisseur> f = service.findById(id);
        return f.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fournisseur> create(@Valid @RequestBody Fournisseur fournisseur) {
        Fournisseur saved = service.save(fournisseur);
        return ResponseEntity.created(URI.create("/api/v1/fournisseurs/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable("id") Long id, @Valid @RequestBody Fournisseur fournisseur) {
        Optional<Fournisseur> existing = service.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Fournisseur updated = service.update(id, fournisseur);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Fournisseur> existing = service.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
