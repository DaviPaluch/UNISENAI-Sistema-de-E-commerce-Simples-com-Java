# UNISENAI-Sistema-de-E-commerce-Simples-com-Java

# 🛒 Sistema de E-commerce Simples

Este é o **Projeto 3** do curso, que tem como objetivo integrar vários conceitos avançados de desenvolvimento de software, como arquitetura MVC, microservices, testes de API e documentação, em um sistema de e-commerce funcional.

## 🎯 Objetivo

Desenvolver um sistema de e-commerce que permita o cadastro e gerenciamento de produtos, criação de carrinhos de compras e finalização de pedidos, proporcionando uma experiência completa para o usuário, desde o login até a finalização da compra.

## 🚀 Funcionalidades

- **Cadastro de Produtos**  
  - Permite cadastrar produtos com nome, descrição, preço e imagem.
  
- **Carrinho de Compras**  
  - Possibilita a criação de um carrinho de compras para o usuário.
  - Adição e remoção de produtos do carrinho.

- **Finalização de Compras**  
  - Calcula o valor total da compra no carrinho.
  - Permite a finalização do pedido.

- **Login e Autenticação**  
  - Usuários podem se cadastrar e realizar login para gerenciar suas compras.

## 🛠️ Tecnologias Utilizadas

- **Back-end**  
  - **Spring Boot**: Framework principal para desenvolvimento.
  - **MySQL**: Banco de dados relacional.
  - **JPA**: Persistência de dados.
  - **RESTful APIs**: Design de APIs para comunicação com o cliente.

- **Testes e Documentação**  
  - **JUnit**: Testes unitários para garantir a funcionalidade e integridade do sistema.
  - **Swagger**: Documentação da API para facilitar o entendimento e o uso.

- **Microservices (opcional)**  
  - **Microservice para Carrinho de Compras**: Microserviço dedicado para gerenciamento do carrinho, caso necessário.

## 📦 Estrutura do Projeto

(será adicionado futuramente 'UML')

## 🔧 Configuração do Ambiente

1. Clone este repositório:
    ```bash
    git clone https://github.com/DaviPaluch/UNISENAI-Sistema-de-E-commerce-Simples-com-Java
    cd UNISENAI-Sistema-de-E-commerce-Simples-com-Java
    ```

2. Configure o banco de dados MySQL:
    - Verifique as configurações de conexão com o banco no arquivo `application.properties`.

3. Inicie o MySQL com Docker:
    - Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.
    - Para iniciar o MySQL com o `docker-compose`, execute o comando:
      ```bash
      docker-compose up -d
      ```
    - Esse comando irá subir um contêiner do MySQL configurado conforme o arquivo `docker-compose.yml`.

4. Execute a aplicação:
    ```bash
    ./mvnw spring-boot:run
    ```



## 🔍 Documentação da API

A documentação da API está disponível com Swagger e pode ser acessada em:

    http://localhost:8080/swagger-ui.html

## ✅ Testes

Execute os testes com:

    ./mvnw test

## 🤝 Contribuição

Contribuições são bem-vindas! Siga os passos:

  Faça um fork do projeto.
  Crie uma branch com sua feature:

    git checkout -b minha-feature

Envie suas alterações:

    git commit -m "Minha nova feature"
    git push origin minha-feature

Desenvolvido com 💙 por Davi Paluch

