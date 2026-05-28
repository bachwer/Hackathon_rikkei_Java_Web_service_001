package re.edu.hackathon.service;


import org.springframework.data.domain.Page;
import re.edu.hackathon.dto.BookCreateDTO;
import re.edu.hackathon.dto.BookUpdateDTO;
import re.edu.hackathon.entity.Book;

public interface IBookService {
    Page<Book> getAllBooks (String keyword, int page, int size);
    Book getBookById(Long id);
    Book createBook(BookCreateDTO dto);
    Book updateBook(Long id, BookUpdateDTO dto);
    void deleteBook(Long id);


}
