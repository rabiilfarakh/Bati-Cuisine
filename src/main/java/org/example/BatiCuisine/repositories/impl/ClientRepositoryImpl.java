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

    private final ClientDao clientDao;

    public ClientRepositoryImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void ajouterClient(Client client) {
        clientDao.ajouterClient(client);
    }

    @Override
    public Optional<Client> afficherInformations(Integer id) {
        return clientDao.afficherInformations(id);
    }

    @Override
    public void appliquerRemise() {
        clientDao.appliquerRemise();
    }

    @Override
    public List chercherClient(String valeur) {
        return clientDao.chercherClient(valeur);
    }
}

