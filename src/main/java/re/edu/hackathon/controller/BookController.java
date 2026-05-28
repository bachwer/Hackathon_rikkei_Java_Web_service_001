package re.edu.hackathon.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.hackathon.dto.BookCreateDTO;
import re.edu.hackathon.dto.BookUpdateDTO;
import re.edu.hackathon.entity.Book;
import re.edu.hackathon.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {



    @Autowired
    private IBookService demoService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        try{
            List<Book> books = demoService.getAllBooks(keyword, page, size).getContent();
            return ResponseEntity.ok(books);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        try{
            Book book = demoService.getBookById(id);
            return ResponseEntity.ok(book);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khi lấy Book Theo ID" + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createBook(@Valid @RequestBody BookCreateDTO dto){
        try{
            Book book = demoService.createBook(dto);
            return ResponseEntity.ok(book);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khởi tạo Book" + e.getMessage());
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@Valid @PathVariable Long id, @RequestBody BookUpdateDTO dto){
        try{
            Book book = demoService.updateBook(id, dto);
            return ResponseEntity.ok(book);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi Khi Update Book" +e.getMessage());
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try{
            demoService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
