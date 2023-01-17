package entities;

import db.Database;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Entity(name = "book")
@Data
@NoArgsConstructor
public class Book {
    static Session session = Database.getHibSesh();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isbn;

    @Column(name = "book_title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "qty_in_library")
    private int qtyInLibrary;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author authorId;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    public Book(String title, String category, int qtyInLibrary, Author authorId, boolean isAvailable) {
        this.title = title;
        this.category = category;
        this.qtyInLibrary = qtyInLibrary;
        this.authorId = authorId;
        this.isAvailable = isAvailable;
    }

    static Scanner sc = new Scanner(System.in);

    public static void addBook(Book book) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        try {
            session.persist(book);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public static void updateBook(String title, int isbn) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Book book = session.get(Book.class, isbn);
        book.setTitle(title);

        try {
            session.merge(book);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteBook(int isbn) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Book book = session.get(Book.class, isbn);

        try {
            session.delete(book);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    // Collections can be used to store the books in the library's collection.
    public static void listBook() {
        Session session = Database.getHibSesh();

        try {
            session.beginTransaction();
            List<Book> books = session.createQuery("from book").list();

            for (Book book : books) {
                System.out.println(book);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static Connection connection = Database.DbConn();
    static Scanner scanner = new Scanner(System.in);

    // Users should be able to search and view books in the library's collection by entering the ISBN
    // or title of the book.


    // Admins should be able to add, update, and delete books from the collection,
    // as well as manage user accounts via the console interface.


    // Users should be able to check out and return books by entering the ISBN of the book,
    // with the option to place a hold on a book if it is currently checked out.
    public static void checkOutBook(int isbn) {
        Session session = Database.getHibSesh();
        System.out.println("Insert the isbn of the book you would like to issue?");
        try {
            session.beginTransaction();
            Book book = session.get(Book.class, isbn);
            if (book.isAvailable) {
                System.out.println("Are you sure you want to check out this book? (yes/no)");
                Scanner scanner = new Scanner(System.in);
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    System.out.println("How many books you want?");
                    int qty = scanner.nextInt();
                    book.setQtyInLibrary(book.getQtyInLibrary() - qty);
                    book.setAvailable(false);
                    session.merge(book);
                    session.flush();
                    System.out.println("Book checked out successfully!");
                } else {
                    System.out.println("Check out cancelled.");
                }
            } else {
                System.out.println("Book is not available.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void returnBook(int isbn) {
        Session session = Database.getHibSesh();
        try {
            session.beginTransaction();
            Book book = session.get(Book.class, isbn);
            if (!book.isAvailable) {
                System.out.println("Are you sure you want to return this book? (yes/no)");
                Scanner scanner = new Scanner(System.in);
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    System.out.println("How many books you want return?");
                    int qty = scanner.nextInt();
                    book.setQtyInLibrary(book.getQtyInLibrary() + qty);
                    book.setAvailable(true);
                    session.merge(book);
                    session.flush();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Return cancelled.");
                }
            } else {
                System.out.println("Book has not been checked out.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//       session.update(qtyInLibrary - qty); - if the rent is made






