package no.oslomet.assignmenttwo.service;

import no.oslomet.assignmenttwo.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAllBookings();

    Booking saveBooking(Booking booking);

    Booking get(final Long id);
}
