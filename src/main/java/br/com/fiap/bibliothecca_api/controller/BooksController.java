package br.com.fiap.bibliothecca_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.bibliothecca_api.model.Book;
import br.com.fiap.bibliothecca_api.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/books")
public class BooksController {
    
    @Autowired
    private BookRepository repository;

    @GetMapping // Get all books
    //@Operation(summary = "Listar todos os Livros", description = "Retorna uma lista com todos os livros encontrados.")
    @Cacheable("books")
    public List<Book> index(){
        return repository.findAll();
    }

    @PostMapping // Create a new book
    @CacheEvict(value = "books", allEntries = true)
    //@Operation(responses = )
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        System.out.println("Cadastrando livro" + book.getName());
        return repository.save(book);
    }

    @GetMapping("{id}") // Get a book by ID
    public ResponseEntity<Book> get(@PathVariable Long id){
        System.out.println("Buscando Livro" + id);
        return ResponseEntity.ok(getBook(id));    
    }

    @DeleteMapping("{id}") // Delete a book by ID
    public ResponseEntity<Book> get(@PathVariable long id){
        System.out.println("Deletando Livro" + id);
        repository.delete(getBook(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}") // Update a book by ID
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        System.out.println("Atualizando Categoria" + id + " com " + book);

        getBook(id);
        book.setId(id);
        repository.save(book);
        return ResponseEntity.ok(book);
    }

    private Book getBook(Long id){
        return repository.findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado")
                );
    }

}
