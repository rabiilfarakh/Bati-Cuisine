package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientDao {

    void ajouterClient(Client client);
    Optional<Client> afficherInformations(Integer id);
    void appliquerRemise();
    List chercherClient(String valeur);
}
