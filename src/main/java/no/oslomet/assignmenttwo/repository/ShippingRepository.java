package no.oslomet.assignmenttwo.repository;

import no.oslomet.assignmenttwo.model.Author;
import no.oslomet.assignmenttwo.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
