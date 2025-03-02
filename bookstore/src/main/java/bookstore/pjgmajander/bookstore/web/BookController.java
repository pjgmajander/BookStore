package bookstore.pjgmajander.bookstore.web;

import bookstore.pjgmajander.bookstore.model.Book;
import bookstore.pjgmajander.bookstore.model.BookRepo;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private final BookRepo repository;

    // constructor injection
    public BookController(BookRepo repository) {
        this.repository = repository;
    }

    //getBookList

    @GetMapping(value = { "/", "/bookList" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    //getBookForm

    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    //saveBookForm

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) { System.out.println("Book ID: " + book.getId());
    System.out.println("Book Title: " + book.getTitle());
        if (book.getId() != null) {
            // Update existing book
            repository.save(book);
            System.out.println("Updating book: " + book);
        } else {
            // Save new book
            repository.save(book);
            System.out.println("Saving new book: " + book);
        }
        return "redirect:/bookList";
        
    }

    //removeBook

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/bookList";
    }


    //editBook

    @RequestMapping(value="/edit/{id}")
    public String showModelBook(@PathVariable("id") Long bookId, Model model) {
        Book book = repository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book-ID: " + bookId));
        System.out.println("Editing book: " + book);
        model.addAttribute("book", book);
        return "editbook";
    }

}

/*
 * @PostMapping("/add")
 * public String addBook(Model model) {
 * model.addAttribute("book", new Book());
 * }
 * }
 */