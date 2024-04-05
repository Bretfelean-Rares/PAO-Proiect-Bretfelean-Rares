package Service;

import Domain.*;
import Repository.BookRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BookstoreService {
    private BookRepository bookRepository;
    private CosCumparaturi cosCumparaturi;
    private IstoricCumparaturi istoric;
    public BookstoreService(BookRepository bookRepository, CosCumparaturi cosCumparaturi, IstoricCumparaturi istoric) {
        this.bookRepository = bookRepository;
        this.cosCumparaturi=cosCumparaturi;
        this.istoric=istoric;
    }

    public void afiseaza_istoric(){
        istoric.afiseazaIstoric();
    }
    // Adauga o carte noua in magazin
    public void adaugaCarte(String titlu, String nume_autor, String prenume_autor, double pret, int stoc) {
        Autor autor= new Autor(nume_autor,prenume_autor);
        Carte carte = new Carte(titlu, autor, pret, stoc);
        bookRepository.adaugaCarte(carte);
    }

    // Sterge o carte din magazin
    public void stergeCarte(String titlu) {
        Carte carte = bookRepository.cautaCarteDupaTitlu(titlu);
        if (carte != null) {
            bookRepository.stergeCarte(carte);
        } else {
            System.out.println("Cartea cu titlul " + titlu + " nu a fost gasita in magazin.");
        }
    }

    public List<Carte> sortBooksByPrice() {
        List<Carte> carti = bookRepository.getToateCartile();
        Collections.sort(carti, Comparator.comparingDouble(Carte::getPret));
        return carti;
    }

    public List<Carte> sortBooksByStock() {
        List<Carte> carti = bookRepository.getToateCartile();
        Collections.sort(carti, Comparator.comparingDouble(Carte::getStoc));
        return carti;
    }

    public void adaugaInCos(Carte carte){
        cosCumparaturi.adaugaCarte(carte);
    }

    public void afiseazaCos(){
        cosCumparaturi.afiseazaCos();
    }

    // Cauta o carte dupa titlu
    public Carte cautaCarteDupaTitlu(String titlu) {
        return bookRepository.cautaCarteDupaTitlu(titlu);
    }

    // Cauta carti dupa autor
    public List<Carte> cautaCartiDupaAutor(String autor) {
        return bookRepository.cautaCarteDupaAutor(autor);
    }

    // Returneaza toate cartile din magazin
    public List<Carte> getToateCartile() {
        return bookRepository.getToateCartile();
    }

    public Map<Client,List<Comanda>> getIstoric(){return istoric.getIstoric();}
    // Actualizeaza stocul pentru o carte existenta
    public void actualizeazaStoc(String titlu, int nouStoc) {
        bookRepository.actualizeazaStoc(titlu, nouStoc);
    }

    public void goleste(Client client){

        Comanda comanda=new Comanda(client);
        for(Carte carte: cosCumparaturi.getToateCartile())
            comanda.adaugaCarteComandata(carte);
        istoric.adaugaComanda(client,comanda);
        for(Carte c : cosCumparaturi.getToateCartile())
            cosCumparaturi.stergeCarte(c);
    }

}
