package org.example.BatiCuisine.repositories.inter;

import org.example.BatiCuisine.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void ajouterClient(Client client);
    Optional<Client> afficherInformations(Integer id);
    void appliquerRemise();
    List chercherClient(String valeur);
}
