package Domain;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private List<Carte> cartiComandate = new ArrayList<>();
    private Client client;

    public Comanda(Client c) {
        this.client = c;
    }

    public void adaugaCarteComandata(Carte carte) {
        cartiComandate.add(carte);
    }

    public List<Carte> getToateCartileComandate() {
        return new ArrayList<>(cartiComandate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comanda pentru clientul ").append(client.getNume()).append(":").append(System.lineSeparator());
        for (Carte carte : cartiComandate) {
            sb.append("- ").append(carte.getTitlu()).append(System.lineSeparator());
        }
        return sb.toString();
    }


}