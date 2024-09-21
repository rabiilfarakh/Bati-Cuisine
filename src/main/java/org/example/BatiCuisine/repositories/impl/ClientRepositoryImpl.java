package org.example.BatiCuisine.repositories.impl;

import org.example.BatiCuisine.dao.inter.ClientDao;
import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.repositories.inter.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {


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

    @Override
    public List chercherClient(String valeur) {
        return List.of();
    }
}

