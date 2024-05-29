# InfoNet - Loja Digital

---

### Descrição do Projeto

**Nome do Projeto:** InfoNet

**Descrição Geral:**
O projeto InfoNet é uma aplicação web voltada para a criação e gestão de uma loja digital, utilizando as tecnologias Java e Spring Boot. A aplicação implementa serviços RESTful que permitem operações de criação, leitura, atualização e deleção (CRUD) de itens no catálogo da loja.

O objetivo do projeto é fornecer uma solução robusta, eficiente e escalável para gerenciar produtos, simplificando o desenvolvimento e a manutenção da loja digital. O InfoNet é projetado para ser facilmente extensível, permitindo futuras integrações com outras plataformas e serviços.

---

### Tecnologias Utilizadas

- **Java 17:** Versão LTS que oferece suporte a longo prazo, com melhorias em desempenho e segurança.
- **Spring Boot 3.3.0:** Framework que simplifica a configuração e o desenvolvimento de aplicações Spring, garantindo uma base sólida e extensível.
- **Spring Web:** Utilizado para criar APIs RESTful, facilitando a interação com a aplicação.
- **Spring Data JPA:** Simplifica a interação com o banco de dados, proporcionando uma camada de persistência eficiente.
- **H2 Database:** Banco de dados em memória utilizado para desenvolvimento e testes, dispensando configurações complexas.
- **Lombok:** Biblioteca que reduz o código boilerplate, como getters, setters e construtores, facilitando o desenvolvimento.
- **Spring DevTools:** Ferramenta que acelera o desenvolvimento com recursos como recarregamento automático de código.

---

### Funcionalidades

- **CRUD de Itens:**
  - **Criar Item (POST /api/items):** Adiciona um novo item ao catálogo.
  - **Ler Todos os Itens (GET /api/items):** Retorna todos os itens do catálogo.
  - **Ler Item por ID (GET /api/items/{id}):** Retorna um item específico pelo ID.
  - **Atualizar Item (PUT /api/items/{id}):** Atualiza as informações de um item existente.
  - **Deletar Item (DELETE /api/items/{id}):** Remove um item do catálogo.

---

### Instalação

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/RafaellSouzza/InfoNet.git
