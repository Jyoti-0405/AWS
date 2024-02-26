package com.nagarro.springaws;

import org.springframework.boot.SpringApplication;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class SpringAwsApplication {
	
	@Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }


    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
        return book;
    }
    @GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the Simple Spring Boot App!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsApplication.class, args);
	}
	
	

}
