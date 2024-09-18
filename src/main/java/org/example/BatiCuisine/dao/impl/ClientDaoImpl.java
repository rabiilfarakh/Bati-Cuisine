package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.ClientDao;
import org.example.BatiCuisine.entities.Client;

import java.util.Optional;

public class ClientDaoImpl implements ClientDao {



    @Override
    public void ajouterClient(Client client) {

    }

    @Override
    public Optional<Client> afficherInformations(Integer id) {
        return Optional.empty();
    }

    @Override
    public void appliquerRemise() {

    }
}
