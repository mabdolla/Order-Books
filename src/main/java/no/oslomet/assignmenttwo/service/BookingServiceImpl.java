package no.oslomet.assignmenttwo.service;

import no.oslomet.assignmenttwo.model.Booking;
import no.oslomet.assignmenttwo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking ) {
        return  bookingRepository.save(booking);
    }

    @Override
    public Booking get(Long id) {
        return bookingRepository.getOne(id);
    }



}
