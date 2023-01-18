import db.Database;
import entities.Book;
import entities.Rent;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.Scanner;

public class RentTest {
    public static void main(String[] args) {
        Session session = Database.getHibSesh();
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();

        try {
            session.beginTransaction();
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter isbn");
            int isbn = sc.nextInt();

            System.out.println("Enter id:");
            int id = sc.nextInt();

            //Save Data
            Rent rent = new Rent();
            rent.setIssueDate(Timestamp.valueOf("2023-01-17 12:02:12"));
            rent.setDueDate(Timestamp.valueOf("2023-01-31 12:02:12"));
            //rent.setClientId(id);
            book.setIsbn(isbn);
            session.merge(rent);
            session.merge(book);
            System.out.println("Congrates Data is Created in database............");

            session.getTransaction().commit();
        } finally {
            // TODO: handle finally clause
            //session.close();
            //factory.close();
        }

    }
}