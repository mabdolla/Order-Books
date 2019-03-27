package no.oslomet.assignmenttwo.repository;

import no.oslomet.assignmenttwo.model.Author;
import no.oslomet.assignmenttwo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
