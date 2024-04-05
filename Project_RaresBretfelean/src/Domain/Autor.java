package Domain;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nume;
    private String prenume;

    public Autor(String nume, String prenume) {
        this.nume = nume;
        this.prenume=prenume;
    }

    public String getNume(){
        return this.nume;
    }

    public String getPrenume(){
        return this.prenume;
    }

    @Override
    public String toString() {
        return getNume().toString() + " " + getPrenume().toString();
    }
}