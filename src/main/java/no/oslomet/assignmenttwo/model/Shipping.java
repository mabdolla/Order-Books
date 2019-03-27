package no.oslomet.assignmenttwo.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"bookings"})
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String firstName;
    public String lastName;
    public String address;
    public int postalCode;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Booking> bookings = new ArrayList<>();

    public Shipping(String firstName, String lastName, String address, int postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
    }
}
