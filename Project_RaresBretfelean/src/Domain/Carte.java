package Domain;

public class Carte {
    private String titlu;
    private Autor autor;
    private double pret;
    private int stoc;

    public Carte(String titlu, Autor autor, double pret, int stoc) {
        this.titlu = titlu;
        this.autor = autor;
        this.pret = pret;
        this.stoc = stoc;
    }

    // Getters and setters
    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    @Override
    public String toString() {
        return
                "Titlu: " + titlu  +
                ", autor " + autor  +
                ", pret " + pret +
                ", stoc " + stoc;
    }
}