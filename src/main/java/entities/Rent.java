package entities;

import db.Database;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Entity(name = "rent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rent_id;

    @Column(name = "issue_date")
    private Timestamp issueDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client_id;

    // @Column(name = "client_id", updatable = false, insertable = false) //Or correct column
    //private int clientId;

    @Column(name = "isreturned")
    private boolean isReturned;

    @JoinColumn (name = "isbn")
    private Book isbn;

    public Rent(Timestamp issueDate, Timestamp dueDate, int client_id, boolean isReturned, int isbn) {
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.client_id.setClient_Id(client_id);
        this.isReturned = isReturned;
        this.isbn.setIsbn(isbn);
    }

    public int getClient_id(int client_id) {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id.setClient_Id(client_id);
    }


    static Session session = Database.getHibSesh();

    // The system should keep track of the due dates for books and
    // send reminders to users when a book is due soon.

    public static String dueDate() {
        //Date today = new Date();
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 14);  // number of days to add
        String dueDate = (String) (formattedDate.format(c.getTime()));
        System.out.println("Your due date is: " + dueDate);


        return dueDate;
    }

    public static String issueDate() {
        //Date today = new Date();
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar c = Calendar.getInstance();
        String issueDate = (String) (formattedDate.format(c.getTime()));
        System.out.println("Your issue date is: " + issueDate);


        return issueDate;
    }

    public static void createNewRent(Rent rent) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        try {
            session.persist(rent);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public static void listRent() {
        Session session = Database.getHibSesh();

        try {
            session.beginTransaction();
            List<Rent> rents = session.createQuery("from rent").list();

            for (Rent rent : rents) {
                System.out.println(rent);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}