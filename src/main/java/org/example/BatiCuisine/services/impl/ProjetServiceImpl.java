package org.example.BatiCuisine.services.impl;

import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.repositories.inter.ProjetRepository;
import org.example.BatiCuisine.services.inter.ProjetService;

import java.util.List;

public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;

    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public void ajouterProjet(Projet projet, Integer clientId) {
        projetRepository.ajouterProjet(projet,clientId);
    }

    @Override
    public Projet afficherProjet(Integer id) {
        return projetRepository.afficherProjet(id);
    }

    @Override
    public void supprimerProjet(Integer id) {
        projetRepository.supprimerProjet(id);
    }

    @Override
    public List<Projet> listerProjetsParClient(Integer clientId) {
        return projetRepository.listerProjetsParClient(clientId);
    }

    @Override
    public List<Projet> listerAllProjets() {
        return projetRepository.listerAllProjets();
    }
}
