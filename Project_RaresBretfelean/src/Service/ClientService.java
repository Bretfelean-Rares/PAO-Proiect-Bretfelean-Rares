package Service;

import Domain.Adresa;
import Domain.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Adauga un nou client
    public void adaugaClient(String nume, String judet, String strada, int cod_postal) {
        int id = generateClientId(); // generate a unique client ID
        Adresa adresa=new Adresa(judet, strada, cod_postal);
        Client client = new Client(id, nume, adresa);
        clientRepository.adaugaClient(client);
    }

    // Sterge un client existent
    public void stergeClient(int clientId) {
        clientRepository.stergeClient(clientId);
    }

    // Cauta un client dupa ID
    public Client cautaClient(int clientId) {
        return clientRepository.cautaClient(clientId);
    }

    // Returneaza toti clientii
    public List<Client> getTotiClientii() {
        return clientRepository.getTotiClientii();
    }

    // Generates a unique client ID
    private int generateClientId() {
        return (int) (Math.random() * 1000);
    }
}
