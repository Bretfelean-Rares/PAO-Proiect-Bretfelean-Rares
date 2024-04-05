package Repository;

import Domain.Carte;

import java.util.*;

public class BookRepository {
    private List<Carte> carti = new ArrayList<>();

    // Adauga o carte in repository
    public void adaugaCarte(Carte carte) {
        carti.add(carte);
    }

    // Sterge o carte din repository
    public void stergeCarte(Carte carte) {
        carti.remove(carte);
    }

    // Cauta o carte dupa titlu
    public Carte cautaCarteDupaTitlu(String titlu) {
        for (Carte carte : carti) {
            if (carte.getTitlu().equalsIgnoreCase(titlu)) {
                return carte;
            }
        }
        return null; // returnam null daca nu gasim cartea
    }

    // Cauta o carte dupa autor
    public List<Carte> cautaCarteDupaAutor(String autor) {
        List<Carte> cartiAutor = new ArrayList<>();
        for (Carte carte : carti) {
            String s=carte.getAutor().getPrenume() + " " + carte.getAutor().getPrenume();
            if (s.equalsIgnoreCase(autor)) {
                cartiAutor.add(carte);
            }
        }
        return cartiAutor;
    }

    // Returneaza toate cartile din repository
    public List<Carte> getToateCartile() {
        return new ArrayList<>(carti);
    }

    // Actualizeaza stocul pentru o carte existenta
    public void actualizeazaStoc(String titlu, int nouStoc) {
        Carte carte = cautaCarteDupaTitlu(titlu);
        if (carte != null) {
            carte.setStoc(nouStoc);
            if(nouStoc==0)
                stergeCarte(carte);
        } else {
            System.out.println("Cartea cu titlul " + titlu + " nu exista in repository.");
        }
    }

}
