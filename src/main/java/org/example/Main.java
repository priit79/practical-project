package org.example;

import db.Database;
import db.DateReminder;
import entities.Book;
import entities.Client;
import entities.Rent;
import menu.Menu;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Session session = Database.getHibSesh();

        //System.out.println("Insert the isbn of the book you would like to return?");
        //Book.returnBook(sc.nextInt());

        /*Rent rent = new Rent ();
        rent.setIssueDate(Timestamp.valueOf("2023-01-17 12:02:12"));
        rent.setDueDate(Timestamp.valueOf("2023-01-31 12:02:12"));
        rent.getClient_id();
        rent.getIsbn();
        rent.isReturned();
        Rent.createNewRent(rent);
         */
        //Book.checkOutBook(sc.nextInt());
        //Book.checkOutBook(sc.nextInt());
        //Book.listBook();
        //Book.checkoutBookByTitle(sc.nextLine());
        //Book.returnBookByTitle(sc.nextLine());

        //Rent rent = session.find(Rent.class, 1);

        //Book book = session.find(Book.class, isbn);
        //Client client = session.find(Client.class, client_id);


        // Rent rent = new Rent(14, Timestamp.valueOf("2023-01-17 12:02:12"), Timestamp.valueOf("2023-01-17 12:02:12"), 4, true);
        //Rent.createNewRent(rent);


        //Book.issueBookByIsbn();

        Menu.mainMenu();


        //Rent.listOfRentedBooks();


        //Rent.listOfRentedBooks();

        //DateReminder dateReminder = new DateReminder();
        //dateReminder.reminder();

        //int clientId = 5;
        //Client client = (Client) session.get(Client.class, clientId);
        //DateReminder dateReminder = new DateReminder();
        //dateReminder.Rent(Timestamp.valueOf("2023-01-17 12:02:12").toLocalDateTime(), Timestamp.valueOf("2023-01-17 12:02:12").toLocalDateTime());
        //dateReminder.reminder(client);

        //Book.searchBooks();
        //Book.searchBooksByTitle();

       /*

        Client client1 = new Client("Daisy Duck", "daisy@gmail.com");
        Client.addClient(client1);
        Client client2 = new Client("Donald Duck", "donald@gmail.com");
        Client.addClient(client2);
        Client client3 = new Client("Hans Goose", "hans@gmail.com");
        Client.addClient(client3);
        Client client4 = new Client("Mickey Mouse", "mickey@gmail.com");
        Client.addClient(client4);
        Client client5 = new Client("Minnie Mouse", "minnie@gmail.com");
        Client.addClient(client5);
        Client client6 = new Client("Goofy Gooferson", "goofy@gmail.com");
        Client.addClient(client6);
        Client client7 = new Client("Robert The Millionaire Duck", "robert@gmail.com");
        Client.addClient(client7);
        Client client8 = new Client("Pluto The Dog", "pluto@gmail.com");
        Client.addClient(client8);
        Client.listClient();

        */


        // Client.listClient();


    }
}