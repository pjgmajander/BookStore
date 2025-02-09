package bookstore.pjgmajander.bookstore.model;

import org.springframework.data.repository.CrudRepository;
import bookstore.pjgmajander.bookstore.model.Book;

public interface BookRepo extends CrudRepository<Book, Long>{

}
