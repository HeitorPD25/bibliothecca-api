package br.com.fiap.bibliothecca_api.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.bibliothecca_api.model.Book;
import br.com.fiap.bibliothecca_api.model.Enums.Categories;
import br.com.fiap.bibliothecca_api.repository.BookRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {
    
    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void init(){
        bookRepository.saveAll(List.of(
            
            Book.builder().name("Harry Potter: O Cálice de Fogo")
                        .category(Categories.Fantasia)
                        .writer("J.K.Rowling")
                        .release_date(LocalDate.of(2000, 7, 8))
                        .build(),

            Book.builder().name("Dom Casmurro")
                        .category(Categories.Drama)
                        .writer("Machado de Assis")
                        .release_date(LocalDate.of(1899, 1, 1))
                        .build(),
            
            Book.builder().name("O Hobbit")
                        .category(Categories.Fantasia)
                        .writer("J.R.R. Tolkien")
                        .release_date(LocalDate.of(1937, 9, 21))
                        .build()                    
        ));
    }
}
