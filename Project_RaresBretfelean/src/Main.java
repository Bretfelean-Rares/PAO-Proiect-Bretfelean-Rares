import Domain.CosCumparaturi;
import Domain.IstoricCumparaturi;
import Repository.BookRepository;
import Repository.ClientRepository;
import Service.BookstoreService;
import Service.ClientService;
import UserInterface.BookstoreUI;

public class Main {
    public static void main(String[] args) {
        // Initialize repository and service for books
        BookRepository bookRepository = new BookRepository();
        CosCumparaturi cos= new CosCumparaturi();
        IstoricCumparaturi istoric = new IstoricCumparaturi();
        BookstoreService bookstoreService = new BookstoreService(bookRepository,cos,istoric);

        // Initialize repository and service for clients
        ClientRepository clientRepository = new ClientRepository();
        ClientService clientService = new ClientService(clientRepository);

        // Populate books
        bookstoreService.adaugaCarte("The Great Gatsby", "F. Scott", "Fitzgerald", 15.99, 100);
        bookstoreService.adaugaCarte("To Kill a Mockingbird", "Harper", "Lee", 12.50, 80);
        bookstoreService.adaugaCarte("1984", "George", "Orwell", 10.75, 120);
        bookstoreService.adaugaCarte("Pride and Prejudice", "Jane","Austen", 14.25, 90);
        bookstoreService.adaugaCarte("The Catcher in the Rye", "J.D.","Salinger", 11.99, 70);
        bookstoreService.adaugaCarte("The Lord of the Rings", "J.R.R.", "Tolkien", 22.50, 110);
        bookstoreService.adaugaCarte("The Hobbit", "J.R.R.", "Tolkien", 18.75, 60);
        bookstoreService.adaugaCarte("Harry Potter and the Philosopher's Stone", "J.K.", "Rowling", 19.99, 150);
        bookstoreService.adaugaCarte("The Da Vinci Code", "Dan", "Brown", 13.50, 85);
        bookstoreService.adaugaCarte("The Alchemist", "Paulo", "Coelho", 16.25, 95);

        // Populate clients
        clientService.adaugaClient("John Smith", "București", "Strada Victoriei", 010000);
        clientService.adaugaClient("Emily Johnson", "Cluj-Napoca", "Strada Observatorului", 400000);
        clientService.adaugaClient("Michael Williams", "Arad", "Strada București", 010000);
        clientService.adaugaClient("Emma Brown", "București", "Strada Unirii", 010000);
        clientService.adaugaClient("Matthew Jones", "Turda", "Strada 1 Decembrie", 401100);
        clientService.adaugaClient("Olivia Davis", "Constantaq", "Strada Libertății", 401100);
        clientService.adaugaClient("Daniel Miller", "Cluj-Napoca", "Strada Mihail Kogălniceanu", 400000);
        clientService.adaugaClient("Sophia Wilson", "Timisoara", "Strada Horea", 400000);
        clientService.adaugaClient("William Moore", "București", "Strada Lipscani", 15433);
        clientService.adaugaClient("Isabella Taylor", "Arad", "Strada Bălcescu", 234556);

        // Initialize UI with both book and client services
        BookstoreUI ui = new BookstoreUI(bookstoreService, clientService);

        // Start the application
        ui.start();
    }
}
