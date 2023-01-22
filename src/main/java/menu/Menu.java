package menu;

import entities.Book;
import entities.Client;
import entities.Rent;

import java.util.Scanner;

/**
 * Menu for library management system
 */
public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Welcome to the library!");
        System.out.println("Pick a role to continue: ");
        System.out.println("1. Client");
        System.out.println("2. Admin"); //Sisselogimine?

        System.out.println("-----------------");
        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                clientMenu();
                break;
            case 2:
                Client.adminLogin();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid option!");
                mainMenu();
                break;
        }
    }


    public static void clientMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Sign up");
        System.out.println("2. List of the books by ISBN");
        System.out.println("3. List of the books by title");
        System.out.println("4. Issue book"); // Carolin checkBook(); OK
        System.out.println("5. Return book");
        System.out.println("6. View all your rented books"); // Client.listOfRentedBooksByClientId(); OK
        System.out.println("7. Exit");


        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to change the role: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Client.addNewClientByClient();
                clientMenu();
                break;
            case 2:
                Book.searchBooks();
                clientMenu();
                break;
            case 3:
                Book.searchBooksByTitle();
                clientMenu();
                break;
            case 4:
                Book.issueBookByIsbn();
                clientMenu();
                break;
            case 5:
                Book.returnBookByIsbn();
                clientMenu();
                break;
            case 6:
                Client.listOfRentedBooksByClientId();
                clientMenu();
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid option!");
                clientMenu();
                break;
        }
    }

    public static void adminMenu() { //Kätlin
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Add a book"); // addBook(); OK aga äkki peaks kuidagi vaatama kas autor eksisteerib
        System.out.println("2. Update a book"); // updateBook(); OK
        System.out.println("3. Delete a book"); // deleteBook(); OK
        System.out.println("4. Add new user"); // addClientByAdmin(); OK
        System.out.println("5. Update user");  //updateClientByAdmin(); OK
        System.out.println("6. Delete user"); //deleteClientByAdmin(); OK
        System.out.println("7. View list of books"); //listBook(); OK
        System.out.println("8. View list of rented books"); // listOfRentedBooks(); OK
        System.out.println("9. Exit"); //mainMenu(); OK

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to change the role: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Book.addBook();
                adminMenu();
                break;
            case 2:
                Book.updateBook();
                adminMenu();
                break;
            case 3:
                Book.deleteBook();
                adminMenu();
                break;
            case 4:
                Client.addNewClientByAdmin();
                adminMenu();
                break;
            case 5:
                Client.updateClientByAdmin();
                adminMenu();
                break;
            case 6:
                Client.deleteClientByAdmin();
                adminMenu();
                break;
            case 7:
                Book.listBook();
                adminMenu();
                break;
            case 8:
                Rent.listOfRentedBooks();
                adminMenu();
                break;
            case 9:
                break;
            default:
                System.out.println("Invalid option!");
                adminMenu();
                break;
        }
    }


}