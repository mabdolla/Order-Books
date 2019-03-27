package no.oslomet.assignmenttwo.service;

import no.oslomet.assignmenttwo.model.Book;
import no.oslomet.assignmenttwo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
     public String deleteBook(long id, Model model) {
        //Book book = this.bookRepository.findById(id).get();
        //bookRepository.delete(book);
        bookRepository.deleteById(id);
        return "redirect:/list";
     }

    @Override
    public Book saveBook(Book book ) {
        return  bookRepository.save(book);
    }

    @Override
    public String editBook(long id, Model model){
        Book book  =this.bookRepository.findById(id).get();
        bookRepository.delete(book);
        model.addAttribute("book", book);
        return "form";
    }

}
