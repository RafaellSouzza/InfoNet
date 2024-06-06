
# InfoNet

Projeto para uma loja digital usando Spring Boot.

## Descrição

Este projeto é uma aplicação de exemplo que demonstra como criar uma loja digital utilizando Spring Boot. O projeto inclui várias funcionalidades como gerenciamento de funcionários, produtos, clientes, categorias e fornecedores. Também inclui testes unitários e integração com Springdoc OpenAPI para documentação da API.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.0**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI**
- **Lombok**
- **Mockito**
- **JUnit 5**

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **Controller**: Contém os controladores REST para as entidades `Funcionario` e `Produto`.
- **Model**: Contém as classes de entidade JPA.
- **Repository**: Contém as interfaces de repositório JPA.
- **Service**: Contém as classes de serviço que implementam a lógica de negócios.
- **Config**: Contém as classes de configuração do Spring, incluindo a configuração do Springdoc OpenAPI.
- **Test**: Contém os testes unitários para os controladores e serviços.

## Pré-requisitos

- **Java 17**: Certifique-se de ter o JDK 17 instalado.
- **Maven**: Certifique-se de ter o Maven instalado.

## Como Rodar o Projeto

1. **Clone o repositório**:

   ```sh
   git clone https://github.com/RafaellSouzza/InfoNet.git
   cd InfoNet
   ```

2. **Instale as dependências e compile o projeto**:

   ```sh
   mvn clean install
   ```

3. **Execute a aplicação**:

   ```sh
   mvn spring-boot:run
   ```

   A aplicação estará disponível em `http://localhost:8080`.

## Usando o Swagger (Springdoc OpenAPI)

A documentação da API está disponível através do Swagger UI, que pode ser acessado em:

```
http://localhost:8080/swagger-ui.html
```

### Passos para Acessar o Swagger UI

1. **Inicie a aplicação** utilizando o comando:

   ```sh
   mvn spring-boot:run
   ```

2. **Abra um navegador web** e acesse o endereço:

   ```
   http://localhost:8080/swagger-ui.html
   ```

3. **Explore a documentação da API**. O Swagger UI fornece uma interface interativa para visualizar e testar os endpoints da API.

## Estrutura do Projeto Atual

### Controladores (Controllers)

- **FuncionarioController**: Gerencia as operações CRUD para funcionários.
- **ProdutoController**: Gerencia as operações CRUD para produtos.

### Serviços (Services)

- **FuncionarioService**: Implementa a lógica de negócios para funcionários.
- **ProdutoService**: Implementa a lógica de negócios para produtos.

### Repositórios (Repositories)

- **FuncionarioRepository**: Interface JPA para operações de persistência de funcionários.
- **ProdutoRepository**: Interface JPA para operações de persistência de produtos.

### Modelos (Models)

- **Funcionario**: Entidade que representa um funcionário.
- **Produto**: Entidade que representa um produto.
- **Categoria**: Entidade que representa uma categoria de produto.
- **Cliente**: Entidade que representa um cliente.
- **Fornecedor**: Entidade que representa um fornecedor.

### Configuração (Config)

- **SpringDocConfig**: Configura o Springdoc OpenAPI para documentação da API.

## Testes

O projeto inclui testes unitários utilizando JUnit 5 e Mockito. Os testes estão localizados no diretório `src/test/java` e incluem testes para controladores e serviços.

### Executando os Testes

Para executar os testes, utilize o seguinte comando Maven:

```sh
mvn test
```
## Licença

Este projeto é licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
