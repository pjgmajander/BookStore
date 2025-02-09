package bookstore.pjgmajander.bookstore.web;
import bookstore.pjgmajander.bookstore.model.BookRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

@Autowired
private final BookRepo repository;
//constructor injection
public BookController(BookRepo repository) {
this.repository = repository;
}

@GetMapping(value= {"/", "/bookList"})
public String bookList(Model model) {
    model.addAttribute("books", repository.findAll());
    return "booklist";
}

}

/*@PostMapping("/add")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
}
}*/