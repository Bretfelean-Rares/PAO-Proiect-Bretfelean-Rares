package Repository;

import Domain.Client;

import java.util.*;

public class ClientRepository {
    private Map<Integer, Client> clients;

    public ClientRepository() {
        this.clients = new TreeMap<>();
    }

    // Adauga un client nou
    public void adaugaClient(Client client) {
        clients.put(client.getId(), client);
    }

    // Sterge un client existent
    public void stergeClient(int clientId) {
        clients.remove(clientId);
    }

    // Cauta un client dupa ID
    public Client cautaClient(int clientId) {
        return clients.get(clientId);
    }

    // Returneaza toti clientii
    public List<Client> getTotiClientii() {
        return new ArrayList<>(clients.values());
    }
}
