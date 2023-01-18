package org.example;

import entities.Book;
import entities.Rent;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //Session session = Database.getHibSesh();
        //System.out.println("Insert the isbn of the book you would like to return?");
        //Book.returnBook(sc.nextInt());


/*
        Rent rent = new Rent();
        rent.setIssueDate(Timestamp.valueOf("2023-01-17 12:02:12"));
        rent.setDueDate(Timestamp.valueOf("2023-01-31 12:02:12"));
        rent.setClient_id(0);
        rent.isReturned();
        Rent.createNewRent(rent);
*/
        Rent rent = new Rent(Timestamp.valueOf("'2023-01-17 12:02:12'"), Timestamp.valueOf("'2023-01-17 12:02:12'"), 5, true, 4);
        Rent.createNewRent(rent);




        //Book.checkOutBook(sc.nextInt());
        //Book.listBook();
        //Book.checkoutBookByTitle(sc.nextLine());
        //Book.returnBookByTitle(sc.nextLine());







    }
}