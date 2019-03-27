package no.oslomet.assignmenttwo.repository;

import no.oslomet.assignmenttwo.model.Author;
import no.oslomet.assignmenttwo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
