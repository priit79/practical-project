package org.example;

import db.Database;
import entities.Book;
import org.hibernate.Session;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //Session session = Database.getHibSesh();
        //System.out.println("Insert isbn:");
        //Book.returnBook(sc.nextInt());
        //Book.checkOutBook(sc.nextInt());
        Book.listBook();






    }
}