package com.cygnus.bookface;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@CrossOrigin(origins="*")
public class BookFaceController {
    @Autowired
    BookFaceRepository repository;


    @GetMapping("/")
    public String getRoot() {
        return "Hello world";
    }

    @PostMapping("/bookfaces")
    public List<String> receiveBookFaceList(@RequestBody List<BookFaceClass> bookfaceList) {
        List<String> booksAdded = new ArrayList<String>();
        bookfaceList.forEach((bookface) -> {
            this.receiveBook(bookface);
            booksAdded.add("Added: " + bookface.getTitle());
        });
        return booksAdded;
    }

    @PostMapping("/bookface")
    public String receiveBook(@RequestBody BookFaceClass bookface) {
        repository.save(bookface);
        return "Book title: " + bookface.getTitle();
    }

    @GetMapping("/bookface")
    public List<BookFaceClass> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/bookface/{id}")
    public BookFaceClass getBookByID(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/bookface/shelf/{shelf}")
    public List<BookFaceClass> getBookByShelf(@PathVariable String shelf) {
        return repository.findByShelf(shelf);
    }

    @GetMapping("/bookface/user/{userdisplayname}")
    public List<BookFaceClass> getBookByUsername(@PathVariable String userdisplayname) {
        return repository.findByUserdisplayname(userdisplayname);
    }

    @GetMapping("/bookface/usershelf")
    @ResponseBody
    public List<BookFaceClass> getBookByUsernameShelf(@RequestParam String userdisplayname, @RequestParam String shelf) {
        List<BookFaceClass> books= repository.findByUserdisplayname(userdisplayname);
        List<BookFaceClass> books2= repository.findByShelf(shelf);
        List<BookFaceClass> result= new ArrayList<BookFaceClass>();
        for(BookFaceClass b:books){
            for(BookFaceClass a:books2){
                if(b.equals(a)){
                    if(!result.contains(b)){
                        result.add(b);
                    }
                }
            }
        }
        return result;
    }

    @PutMapping("/bookface/{id}") 
    public BookFaceClass updateBook(@PathVariable Long id, @RequestBody BookFaceClass book) {
        if (repository.existsById(id)) {
            return repository.save(new BookFaceClass(book, id));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

    @DeleteMapping("/bookface/{id}")
    public void deleteBook(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}