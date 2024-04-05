package Domain;

import java.util.ArrayList;
import java.util.List;

class Roman extends Carte {
    private String gen;

    public Roman(String titlu, Autor autor, double pret, int stoc, String gen) {
        super(titlu, autor, pret, stoc);
        this.gen = gen;
    }

    public String getGen(){
        return gen;
    }
}

