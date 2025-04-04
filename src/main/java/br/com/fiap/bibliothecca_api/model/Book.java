package br.com.fiap.bibliothecca_api.model;

import java.util.Date;

import br.com.fiap.bibliothecca_api.model.Enums.Categories;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Book {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome não pode estar em branco.")
    @Pattern(regexp = "^[A-Z].*", message = "Deve começar com letra maiúscula")
    @Size(min = 5)
    private String name;

    @NotNull(message = "Você deve escolher uma categoria.")
    private Categories category;

    @NotBlank(message = "O Nome não pode estar em branco.")
    @Pattern(regexp = "^[A-Z].*", message = "Deve começar com letra maiúscula")
    @Size(min = 5)
    private String writer;

    @NotNull
    @PastOrPresent
    private Date release_date;
    
}
