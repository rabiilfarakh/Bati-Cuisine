package org.example.BatiCuisine.services.inter;

import org.example.BatiCuisine.entities.Client;

import java.util.Optional;

public interface ClientService {

    void ajouterClient(Client client);
    Optional<Client> afficherInformations(Integer id);
    void appliquerRemise();
}
