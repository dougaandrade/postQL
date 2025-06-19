# Spring Boot + GraphQL - Post Simples 📚

Projeto simples para mostrar o uso de GraphQL com Spring Boot usando Postgres.

## Requisitos 📋

- Java 17+
- Maven 3+
- IDE (IntelliJ, VSCode, Eclipse...)
- DBeaver
- Docker Compose

## Rodando a aplicação ⚙️

1. Clone o projeto
2. Execute `mvn spring-boot:run`
3. Acesse o GraphiQL no browser: `http://localhost:8080/graphiql`
4. Use as queries e mutations para testar

## Exemplos de uso ⌨️

### Query para pegar todos os post's
   
```graphql
query {
   allPosts {
    id
    title
    content
  }
}
```

### Query para criar o post
```graphql
mutation {
  createPost(post: {
    title: "Primeiro post",
    content: "Esse é o conteúdo do primeiro post"
  }) {
    id
    title
    content
  }
}
```
   
### Query para pegar buscar post pelo ID
```graphql
query {
  postById(id: 2) {
    id
    title
    content
  }
}
```
   
### Query para atualizar post por ID
```graphql
mutation {
  updatePost(id: 10, post: {
    title: "Título Atualizado"
    content: "Conteúdo atualizado com sucesso"
  }) {
    id
    title
    content
  }
}
```

