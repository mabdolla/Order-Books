package no.oslomet.assignmenttwo.repository;

import no.oslomet.assignmenttwo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
