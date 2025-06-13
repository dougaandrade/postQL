# Spring Boot + GraphQL - Biblioteca Simples 📚

Projeto simples para mostrar o uso de GraphQL com Spring Boot usando banco em memória H2.

## Requisitos 📋

- Java 17+
- Maven 3+
- IDE (IntelliJ, VSCode, Eclipse...)
- Scalar

## Rodando a aplicação ⚙️

1. Clone o projeto
2. Execute `mvn spring-boot:run`
3. Acesse o GraphiQL no browser: `http://localhost:8080/graphiql`
4. Use as queries e mutations para testar

## Exemplos de uso ⌨️

### Query para pegar todos os livros

```graphql
query {
  allBooks {
    id
    title
    author
  }
}
