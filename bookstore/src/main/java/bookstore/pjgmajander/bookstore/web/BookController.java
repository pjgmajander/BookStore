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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        System.out.println("Saving book: " + book);
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
        model.addAttribute("book", repository.findById(bookId));
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