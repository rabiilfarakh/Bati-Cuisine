package org.example.BatiCuisine.services.impl;

import org.example.BatiCuisine.dao.inter.ClientDao;
import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.repositories.inter.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClientServiceImpl implements ClientDao {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void ajouterClient(Client client) {
        clientRepository.ajouterClient(client);
    }

    @Override
    public Optional<Client> afficherInformations(Integer id) {
        return clientRepository.afficherInformations(id);
    }

    @Override
    public void appliquerRemise() {
        clientRepository.appliquerRemise();
    }

    @Override
    public List chercherClient(String valeur) {
        return clientRepository.chercherClient(valeur);
    }
}
