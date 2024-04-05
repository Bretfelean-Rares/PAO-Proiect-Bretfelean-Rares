package Domain;

import java.util.ArrayList;
import java.util.List;

public class CosCumparaturi {
    private List<Carte> carti = new ArrayList<>();

    public void adaugaCarte(Carte carte) {
        carti.add(carte);
    }

    public void afiseazaCos() {
        for (Carte carte : carti) {
            System.out.println(carte);
        }
    }

    public void stergeCarte(Carte carte) {
        carti.remove(carte);
    }

    public List<Carte> getToateCartile() {
        return new ArrayList<>(carti);
    }

}