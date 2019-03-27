package no.oslomet.assignmenttwo.repository;

import no.oslomet.assignmenttwo.model.Author;
import no.oslomet.assignmenttwo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
