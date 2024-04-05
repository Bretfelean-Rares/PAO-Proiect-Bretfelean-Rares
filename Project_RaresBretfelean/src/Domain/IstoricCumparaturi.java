package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IstoricCumparaturi {
    private Map<Client, List<Comanda>> istoric = new HashMap<>();

    public void adaugaComanda(Client client, Comanda comanda) {
        if (istoric.containsKey(client)) {
            istoric.get(client).add(comanda);
        } else {
            List<Comanda> comenzi = new ArrayList<>();
            comenzi.add(comanda);
            istoric.put(client, comenzi);
        }
    }

    public Map<Client, List<Comanda>> getIstoric(){
        return new HashMap<>(istoric);
    }

    public void afiseazaIstoric() {
        System.out.println("Istoricul de cumparaturi:");

        for (Map.Entry<Client, List<Comanda>> entry : istoric.entrySet()) {
            Client client = entry.getKey();
            List<Comanda> comenzi = entry.getValue();

            System.out.println("Client: " + client.getNume()); // Sau alte informații relevante despre client

            for (Comanda comanda : comenzi) {
                System.out.println("- " + comanda.toString()); // Sau alte informații relevante despre comandă
            }
        }
    }
}