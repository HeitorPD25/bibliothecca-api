package br.com.fiap.bibliothecca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bibliothecca_api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
} 

