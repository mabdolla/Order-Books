package no.oslomet.assignmenttwo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @Column(name = "name", columnDefinition="VARCHAR(64)")
    public String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)

    private List<Book> books = new ArrayList<>();
}
