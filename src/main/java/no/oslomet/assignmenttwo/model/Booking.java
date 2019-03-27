package no.oslomet.assignmenttwo.model;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"shipping"})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Temporal(TemporalType.DATE)
    private Date date;


//    public String date(Date date){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        //Date date = new Date();
//        return simpleDateFormat.format(date);
//    }

    public Booking(Date date, Shipping shipping, Book book) {
        this.date = date;
        this.shipping = new Shipping();
        this.books = getBooks();
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn
    public Shipping shipping;

    @ManyToMany(mappedBy = "bookings")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Book> books = new ArrayList<>();


    public Booking(Date date) {
    }
}
