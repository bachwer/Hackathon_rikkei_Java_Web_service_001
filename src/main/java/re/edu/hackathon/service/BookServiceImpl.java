package re.edu.hackathon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.edu.hackathon.constance.StatusType;
import re.edu.hackathon.dto.BookCreateDTO;
import re.edu.hackathon.dto.BookUpdateDTO;
import re.edu.hackathon.entity.Book;
import re.edu.hackathon.repository.BookRepository;


@Service
public class BookServiceImpl implements IBookService {


    @Autowired
    private BookRepository bookRepository;


    @Override
    public Page<Book> getAllBooks(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findByTitleContainsOrAuthorContaining(keyword,keyword, pageable);

    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
    }

    @Override
    public Book createBook(BookCreateDTO dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .status(StatusType.AVAILABLE)
                .is_Deleted(false)
                .build();
        return bookRepository.save(book);
    }
    @Override
    public Book updateBook(Long id, BookUpdateDTO dto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setStatus(dto.getStatus());
        return bookRepository.save(book);
    }
    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        bookRepository.delete(book);
    }


}
