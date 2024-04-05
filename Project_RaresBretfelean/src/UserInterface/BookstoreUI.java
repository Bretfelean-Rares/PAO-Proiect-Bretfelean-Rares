package UserInterface;

import Domain.Autor;
import Domain.Carte;
import Domain.Client;
import Service.BookstoreService;
import Service.ClientService;

import java.util.List;
import java.util.Scanner;

public class BookstoreUI {
    private BookstoreService bookstoreService;
    private ClientService clientService;
    private Scanner scanner;

    public BookstoreUI(BookstoreService bookstoreService, ClientService clientService) {
        this.bookstoreService = bookstoreService;
        this.clientService = clientService;
        this.scanner = new Scanner(System.in);
    }

    // Metoda pentru afisarea meniului pentru operatii cu carti
    public void afisareMeniuCarti() {
        System.out.println("=== OPERATII CU CARTI ===");
        System.out.println("0. Inapoi");
        System.out.println("1. Adauga carte");
        System.out.println("2. Sterge carte");
        System.out.println("3. Cauta carte dupa titlu");
        System.out.println("4. Afiseaza toate cartile");
        System.out.println("5. Sorteaza carti dupa pret");
        System.out.println("6. Sorteaza carti dupa stoc");
        System.out.println("7. Adauga carte in cos");
        System.out.println("8. Afiseaza cosul de cumparaturi");
        System.out.println("9. Comanda cartile din cos");
        System.out.println("10. Afiseaza istoric cumparaturi");
        System.out.println("=========================");
    }

    // Metoda pentru afisarea meniului pentru operatii cu clienti
    public void afisareMeniuClienti() {
        System.out.println("=== OPERATII CU CLIENTI ===");
        System.out.println("0. Inapoi");
        System.out.println("7. Adauga client");
        System.out.println("8. Sterge client");
        System.out.println("9. Cauta client dupa ID");
        System.out.println("10. Afiseaza toti clientii");
        System.out.println("============================");
    }

    // Metoda pentru afisarea meniului principal
    public void afisareMeniuPrincipal() {
        System.out.println("=== MENIU PRINCIPAL ===");
        System.out.println("1. Operatii cu carti");
        System.out.println("2. Operatii cu clienti");
        System.out.println("0. Iesire");
        System.out.println("=======================");
        System.out.print("Alege optiunea: ");
    }

    // Metoda pentru citirea unei optiuni din meniu
    public int citesteOptiune() {
        return scanner.nextInt();
    }

    // Metoda pentru citirea detaliilor unei noi carti
    public void citesteDetaliiCarte() {
        scanner.nextLine(); // Consumam newline
        System.out.print("Titlu: ");
        String titlu = scanner.nextLine();
        System.out.print("Prenume Autor: ");
        String prenume_autor = scanner.nextLine();
        System.out.print("Nume Autor: ");
        String nume_autor = scanner.nextLine();
        System.out.print("Pret: ");
        double pret = scanner.nextDouble();
        System.out.print("Stoc: ");
        int stoc = scanner.nextInt();
        bookstoreService.adaugaCarte(titlu, prenume_autor,nume_autor, pret, stoc);
        System.out.println("Cartea a fost adaugata cu succes!");
    }

    // Metoda pentru citirea titlului unei carti pentru stergere
    public void citesteTitluStergereCarte() {
        scanner.nextLine(); // Consumam newline
        System.out.print("Introduceti titlul cartii de sters: ");
        String titlu = scanner.nextLine();
        bookstoreService.stergeCarte(titlu);
        System.out.println("Cartea a fost stearsa cu succes!");
    }

    // Metoda pentru cautarea unei carti dupa titlu
    public void cautareCarteDupaTitlu() {
        scanner.nextLine(); // Consumam newline
        System.out.print("Introduceti titlul cartii cautate: ");
        String titlu = scanner.nextLine();
        Carte carte = bookstoreService.cautaCarteDupaTitlu(titlu);
        if (carte != null) {
            System.out.println("Cartea gasita: " + carte);
        } else {
            System.out.println("Cartea nu a fost gasita in magazin.");
        }
    }

    // Metoda pentru afisarea tuturor cartilor din magazin
    public void afisareToateCartile() {
        System.out.println("Toate cartile din magazin:");
        bookstoreService.getToateCartile().forEach(System.out::println);
    }

    // Metoda pentru sortarea cartilor dupa pret
    public void sorteazaCartiDupaPret() {
        List<Carte> c = bookstoreService.sortBooksByPrice();
        System.out.println("Cartile au fost sortate dupa pret: ");
        for(int i=0;i<c.size();i++){
            System.out.println(c.get(i).toString());

        }
    }

    public void sorteazaCartiDupaStoc() {
        List<Carte> c = bookstoreService.sortBooksByStock();
        System.out.println("Cartile au fost sortate dupa stoc: ");
        for(int i=0;i<c.size();i++){
            System.out.println(c.get(i).toString());

        }
    }

    // Metoda pentru citirea detaliilor unui nou client
    public void citesteDetaliiClient() {
        scanner.nextLine(); // Consumam newline
        System.out.print("Nume client: ");
        String nume = scanner.nextLine();
        System.out.print("Oras client: ");
        String oras = scanner.nextLine();
        System.out.print("Strada client: ");
        String strada = scanner.nextLine();
        System.out.print("Cod Postal client: ");
        int cod = Integer.parseInt(scanner.nextLine());
        clientService.adaugaClient(nume, oras,strada,cod);
        System.out.println("Clientul a fost adaugat cu succes!");
    }

    // Metoda pentru citirea ID-ului clientului pentru stergere
    public void citesteIdStergereClient() {
        System.out.print("Introduceti ID-ul clientului de sters: ");
        int clientId = scanner.nextInt();
        clientService.stergeClient(clientId);
        System.out.println("Clientul a fost sters cu succes!");
    }

    // Metoda pentru cautarea unui client dupa ID
    public void cautareClientDupaId() {
        System.out.print("Introduceti ID-ul clientului cautat: ");
        int clientId = scanner.nextInt();
        Client client = clientService.cautaClient(clientId);
        if (client != null) {
            System.out.println("Clientul gasit: " + client);
        } else {
            System.out.println("Clientul nu a fost gasit.");
        }
    }

    // Metoda pentru afisarea tuturor clientilor
    public void afisareTotiClientii() {
        System.out.println("Toti clientii:");
        clientService.getTotiClientii().forEach(System.out::println);
    }

    public void afisareIstoric(){
        System.out.println("Istoric:");
        bookstoreService.afiseaza_istoric();
    }

    // Metoda pentru rularea interfetei
    public void start() {
        int optiune;
        do {
            afisareMeniuPrincipal();
            optiune = citesteOptiune();
            switch (optiune) {
                case 1:
                    handleOperatiiCarti();
                    break;
                case 2:
                    handleOperatiiClienti();
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Optiune invalida. Va rugam selectati o optiune valida.");
            }
        } while (optiune != 0);
    }

    // Metoda pentru gestionarea operatiilor cu carti
    private void handleOperatiiCarti() {
        int optiuneCarti;
        do {
            afisareMeniuCarti();
            optiuneCarti = citesteOptiune();
            switch (optiuneCarti) {
                case 0:
                    start();
                    break;
                case 1:
                    citesteDetaliiCarte();
                    break;
                case 2:
                    citesteTitluStergereCarte();
                    break;
                case 3:
                    cautareCarteDupaTitlu();
                    break;
                case 4:
                    afisareToateCartile();
                    break;
                case 5:
                    sorteazaCartiDupaPret();
                    break;
                case 6:
                    sorteazaCartiDupaStoc();
                    break;
                case 7:
                    adaugaInCos();
                    break;
                case 8:
                    bookstoreService.afiseazaCos();
                    break;
                case 9:
                    golire();
                    break;
                case 10:
                    afisareIstoric();
                    break;
                default:
                    System.out.println("Optiune invalida. Va rugam selectati o optiune valida.");
            }
        } while (optiuneCarti != 0);
    }


    private void golire(){
        System.out.print("Introduceti ID-ul clientului cautat: ");
        int clientId = scanner.nextInt();
        Client client = clientService.cautaClient(clientId);
        if (client != null) {
            System.out.println("Clientul gasit: " + client);
            bookstoreService.goleste(client);

        } else {
            System.out.println("Clientul nu a fost gasit.");
        }
    }
    private void adaugaInCos(){
        scanner.nextLine(); // Consumam newline
        System.out.print("Introduceti titlul cartii cautate: ");
        String titlu = scanner.nextLine();
        Carte carte = bookstoreService.cautaCarteDupaTitlu(titlu);
        if (carte != null) {
            System.out.println("Cartea gasita: " + carte);
            bookstoreService.actualizeazaStoc(carte.getTitlu(), carte.getStoc()-1);
            bookstoreService.adaugaInCos(carte);

        } else {
            System.out.println("Cartea nu a fost gasita in magazin.");
        }
    }
    // Metoda pentru gestionarea operatiilor cu clienti
    private void handleOperatiiClienti() {
        int optiuneClienti;
        do {
            afisareMeniuClienti();
            optiuneClienti = citesteOptiune();
            switch (optiuneClienti) {
                case 0:
                    start();
                    break;
                case 7:
                    citesteDetaliiClient();
                    break;
                case 8:
                    citesteIdStergereClient();
                    break;
                case 9:
                    cautareClientDupaId();
                    break;
                case 10:
                    afisareTotiClientii();
                    break;
                default:
                    System.out.println("Optiune invalida. Va rugam selectati o optiune valida.");
            }
        } while (optiuneClienti != 0);
    }
}
