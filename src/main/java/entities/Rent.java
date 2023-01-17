package entities;
import db.Database;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;
import java.util.Scanner;

import static entities.Book.session;

@Entity(name = "rent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentId;

    @OneToOne
    @JoinColumn(name = "isbn")
    private Book isbn;

    @Column(name = "issue_date")
    private Timestamp issueDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @Column (name = "isReturned")
    private boolean isReturned;

    public Rent(Book isbn, Timestamp issueDate, Timestamp dueDate, Client clientId, boolean isReturned) {
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.clientId = clientId;
        this.isReturned = isReturned;
    }

    static Scanner scanner = new Scanner(System.in);







    // The system should keep track of the due dates for books and
    // send reminders to users when a book is due soon.


}