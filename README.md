
# Bibliotheca API 📚

**Bibliotheca API** é uma aplicação RESTful desenvolvida em Java com Spring Boot, projetada para gerenciar o acervo de uma biblioteca. A API permite operações de criação, leitura, atualização e exclusão (CRUD) de livros, categorias e autores.

## 🛠 Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework para facilitar o desenvolvimento da aplicação.
- **Maven**: Gerenciador de dependências e automação de build.
- **Jakarta Annotations**: Utilizadas para injeção de dependências e configurações.
- **Banco de Dados**: Configurável conforme a necessidade (H2, PostgreSQL, MySQL, etc.).

## 📂 Estrutura do Projeto

```
bibliothecca-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br
│   │   │       └── com
│   │   │           └── fiap
│   │   │               └── bibliothecca_api
│   │   │                   ├── config        # Configurações gerais (como seed de dados)
│   │   │                   ├── controller    # Controllers REST
│   │   │                   ├── model         # Entidades e Enums
│   │   │                   └── repository    # Interfaces JPA
│   │   └── resources
│   │       └── application.properties        # Configurações da aplicação
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## 🚀 Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/HeitorPD25/bibliothecca-api.git
   ```

2. **Acesse o diretório do projeto**:
   ```bash
   cd bibliothecca-api
   ```

3. **Configure o banco de dados**:
   - No arquivo `application.properties`, configure as propriedades do banco de dados conforme sua preferência (H2, PostgreSQL, MySQL, etc.).
   - Exemplo para H2 (banco em memória):
     ```properties
     spring.datasource.url=jdbc:h2:mem:bibliotheca
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     ```

4. **Execute a aplicação**:
   - No terminal, utilize o comando:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou, caso esteja utilizando uma IDE, execute a classe principal `BibliotheccaApiApplication`.

A aplicação estará disponível em `http://localhost:8080`.

## 📘 Exemplos de Uso

### Listar Todos os Livros

**Requisição**:
```http
GET /books
```

**Resposta**:
```json
[
  {
    "id": 1,
    "name": "Harry Potter: O Cálice de Fogo",
    "category": "FANTASIA",
    "writer": "J.K. Rowling",
    "release_date": "2000-07-08"
  },
  {
    "id": 2,
    "name": "Dom Casmurro",
    "category": "DRAMA",
    "writer": "Machado de Assis",
    "release_date": "1899-01-01"
  }
]
```

### Adicionar um Novo Livro

**Requisição**:
```http
POST /books
Content-Type: application/json

{
  "name": "O Hobbit",
  "category": "FANTASIA",
  "writer": "J.R.R. Tolkien",
  "release_date": "1937-09-21"
}
```

**Resposta**:
```json
{
  "id": 3,
  "name": "O Hobbit",
  "category": "FANTASIA",
  "writer": "J.R.R. Tolkien",
  "release_date": "1937-09-21"
}
```

## 🧪 Seed de Dados

O projeto inclui uma classe `DatabaseSeeder` que popula o banco de dados com dados iniciais ao iniciar a aplicação. Isso é útil para testes e demonstrações.

## 📄 Licença

Este projeto está sob a licença MIT. Para mais detalhes, consulte o arquivo `LICENSE` no repositório.
