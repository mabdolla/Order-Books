package no.oslomet.assignmenttwo.service;

import no.oslomet.assignmenttwo.model.Book;
import org.springframework.ui.Model;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();


    //String deleteBook(long id );


    String deleteBook(long id, Model model);

    Book saveBook(Book book);

    String editBook(long ISBN, Model model);
}
