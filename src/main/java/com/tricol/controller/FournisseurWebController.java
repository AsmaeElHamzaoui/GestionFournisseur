package com.tricol.controller;

import com.tricol.model.Fournisseur;
import com.tricol.service.IFournisseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurWebController {

    private final IFournisseurService service;

    @Autowired
    public FournisseurWebController(IFournisseurService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model, @RequestParam(value = "q", required = false) String q) {
        if (q != null && !q.isBlank()) {
            model.addAttribute("fournisseurs", service.searchBySociete(q));
        } else {
            model.addAttribute("fournisseurs", service.findAllSortedBySociete());
        }
        model.addAttribute("q", q);
        return "list-fournisseurs";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("fournisseur", new Fournisseur());
        return "add-fournisseur";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Fournisseur fournisseur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-fournisseur";
        }
        service.save(fournisseur);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        return service.findById(id)
                .map(f -> {
                    model.addAttribute("fournisseur", f);
                    return "edit-fournisseur";
                })
                .orElse("redirect:/fournisseurs");
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute Fournisseur fournisseur, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-fournisseur";
        }
        service.update(id, fournisseur);
        return "redirect:/fournisseurs";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/fournisseurs";
    }
}
