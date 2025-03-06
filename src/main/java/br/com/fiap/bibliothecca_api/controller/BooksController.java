package br.com.fiap.bibliothecca_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bibliothecca_api.model.Book;

@RestController
public class BooksController {
    
    private List<Book> repository = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> index(){
        return repository;
    }

    @PostMapping("/books")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        System.out.println("Cadastrando livro" + book.getName());
        repository.add(book);
        return book;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id){
        System.out.println("Buscando Livro" + id);
        var book = repository.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();

        if (book.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book.get());
    }


}
