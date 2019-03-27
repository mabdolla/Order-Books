package no.oslomet.assignmenttwo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Book {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    public long ISBN;
    public String title;
    public String releaseYear;
    public int quantity;

    public Book(long ISBN, String title, String releaseYear, int quantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.releaseYear = releaseYear;
        this.quantity = quantity;
    }


    @ManyToOne
    @JoinColumn(name = "category_name" /*, nullable=false*/ )
    @NotFound(action = NotFoundAction.IGNORE)
    private Category category;

    @ManyToMany(mappedBy = "books")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(
            name = "Book_Booking",
            joinColumns = { @JoinColumn(name = "book_isbn") },
            inverseJoinColumns = { @JoinColumn(name = "booking_id") }
    )
    List<Book> bookings = new ArrayList<>();



}
