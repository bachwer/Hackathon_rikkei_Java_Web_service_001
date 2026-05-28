package re.edu.hackathon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.hackathon.entity.Book;

public interface BookRepository  extends JpaRepository<Book, Long> {

    Page<Book> findByTitleContainsOrAuthorContaining(String title, String author, Pageable pageable);
    
    
    
    
}
