package no.oslomet.assignmenttwo.controller;

import no.oslomet.assignmenttwo.model.*;
import no.oslomet.assignmenttwo.service.BookService;
import no.oslomet.assignmenttwo.service.BookingService;
import no.oslomet.assignmenttwo.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ShippingService shippingService;

    @GetMapping("/")
    public String home(Model model){

        Book book = new Book(234678905, "Sjalusi","1834", 20);
        saveBook(book, model);

        Date date = new Date();
        Shipping shipping = new Shipping("Mohammad","Abdolla","OsloMetveien 35", 1002);
        Booking booking = new Booking(date,shipping,book);

        saveBooking(booking,shipping,model);
        saveShipping(shipping,model);


        Author author = new Author();
        Category category = new Category();
        return "redirect:/bookList";
    }

    @GetMapping("/addBook")
    public String addBook(Book book){
        return "bookForm";
    }

    @GetMapping("/bookList")
    public String listBooks(Model model ){
        model.addAttribute("books", bookService.findAllBooks());
        return "bookList";
    }

    @PostMapping("/saveBook")
    public String saveBook(Book book, Model model){
        bookService.saveBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/bookList";
    }

    @GetMapping("/edit/{ISBN}")
    public String editBook(@PathVariable("ISBN") long id, Model model){
        bookService.editBook(id,model);
        return "bookForm";
    }

    @GetMapping("/delete/{ISBN}")
    public String deleteBook(@PathVariable("ISBN") long id, Model model){
        bookService.deleteBook(id, model);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/bookList";
    }



    @PostMapping("/saveBooking")
    public String saveBooking(Booking booking, Shipping shipping, Model model){
        bookingService.saveBooking(booking);
        model.addAttribute("bookings",bookingService.findAllBookings());
        return "redirect:/booking/{id}";
    }

//    @GetMapping("/addShipping")
//    public String addShipping(Shipping shipping){
//        return "bookingForm";
//    }

    @GetMapping("/saveShipping")
    public String saveShipping(Shipping shipping, Model model){
        shippingService.saveShipping(shipping);
        model.addAttribute("shippings", shippingService.findAllShippings());
        return "bookingList";
    }

    @GetMapping("/booking/{id}")
    public String getBooking(@PathVariable(name = "id", required = true) Long id, Model model) {
        Booking booking = bookingService.get(id);
        model.addAttribute(booking);
        return "bookingList";
    }

    @GetMapping("/addBooking")
    public String addBooking(Booking booking){
        return "bookingForm";
    }

    @GetMapping("/addShipping")
    public String addShipping(Shipping shipping){
        return "shippingForm";
    }





}
