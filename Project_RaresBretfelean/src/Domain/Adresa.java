package Domain;

public class Adresa {
    private String oras, strada;
    private int cod_postal;
    public Adresa(String oras, String strada, int cod_postal){
        this.oras=oras;
        this.strada=strada;
        this.cod_postal=cod_postal;
    }

    @Override
    public String toString() {
        return "Oras: " + oras
                + ", " + strada  +
                ", Cod Postal: " + cod_postal ;
    }
}
