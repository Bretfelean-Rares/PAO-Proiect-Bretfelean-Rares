package Domain;

import java.util.*;

public class Client {
    private int id;
    private String nume;
    private Adresa adresa;

    public Client(int id, String nume, Adresa adresa) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return
                "Id: " + id +
                ", Nume: " + nume +
                ", Adresa: " + adresa.toString();
    }
}
