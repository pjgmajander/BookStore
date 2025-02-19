package bookstore.pjgmajander.bookstore.model;

import org.springframework.data.repository.CrudRepository;
//import bookstore.pjgmajander.bookstore.model.Book;
import java.util.List;
import java.math.BigDecimal;

public interface BookRepo extends CrudRepository<Book, Long> {
//List<Book> findById(Long id);
List<Book> findByTitleIgnoreCase(String title);
List<Book> findByAuthorIgnoreCase(String author);
List<Book> findByIsbnIgnoreCase(String isbn);
List<Book> findByPublicationYear(Integer publicationYear);
List<Book> findByPrice(BigDecimal price);
List<Book> findByAuthorOrderByTitleAsc(String author);
List<Book> findByAuthorOrderByPriceAsc(String author);
}

