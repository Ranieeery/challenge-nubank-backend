# Nubank Backend Challenge - API REST de Clientes e Contatos

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue.svg)](https://www.docker.com/)


API REST desenvolvida em **Java 21** com **Spring Boot 3.5** para gerenciamento de clientes e seus contatos para desafio técnico do Nubank.

## Descrição do Desafio

Construa uma API REST para gerenciamento de clientes e seus contatos. Cada cliente pode ter um ou mais contatos associados.

### Requisitos Técnicos

- **Cadastro** de Cliente (POST /clientes)
- **Cadastro** de Contato (POST /contatos) associado a um cliente existente
- **Listagem** de todos os clientes com seus contatos (GET /clientes)
- **Listagem** de contatos de um cliente específico (GET /clientes/{id}/contatos)
- Uso de Spring Boot + Spring Data JPA
- Banco de dados PostgreSQL
- Entidades Cliente e Contato com relacionamento OneToMany/ManyToOne
- Banco PostgreSQL rodando em container Docker

### Requisitos de Código

- Separação de responsabilidades (camadas: controller, service, repository)
- Uso de DTOs para entrada e saída de dados
- Tratamento adequado de erros
- Usar Lombok

## Como Executar

### Pré-requisitos

- **Java 21+** ([Amazon Corretto](https://aws.amazon.com/corretto/) recomendado)
- **Maven 3.6+**
- **PostgreSQL**

### Execução Local

```bash
# Clonar o repositório
git clone <repository-url>
cd nubank-backend

# Criar configuração do banco de dados (Docker)
docker-compose up -d

# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

A API estará disponível em: **http://localhost:8080**

## Endpoints da API

### **POST** `/clientes` - Criar Cliente

Cria um novo cliente com seus contatos associados.

**Payload:**
```json
{
  "nome": "Pedro Fulano",
  "contatos": [
    {
      "nome": "João Trabalho",
      "telefone": "(11) 99999-9999",
      "email": "joao.trabalho@email.com"
    }
  ]
}
```

**Respostas:**
- `201 Created` - Cliente criado com sucesso
- `400 Bad Request` - Dados inválidos

### **GET** `/clientes` - Listar Todos os Clientes

Retorna todos os clientes com seus contatos.

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Pedro Fulano",
    "contatos": [
      {
        "id": 1,
        "nome": "João Trabalho",
        "telefone": "(11) 99999-9999",
        "email": "joao.trabalho@email.com",
        "clienteId": 1
      }
    ]
  }
]
```

### **GET** `/clientes/{id}/contatos` - Listar Contatos de um Cliente

Retorna todos os contatos de um cliente específico.

**Respostas:**
- `200 OK` - Lista de contatos retornada
- `404 Not Found` - Cliente não encontrado

### **POST** `/contatos` - Criar Contato

Cria um novo contato associado a um cliente existente.

**Payload:**
```json
{
  "nome": "Maria Gerente",
  "telefone": "(11) 88888-8888",
  "email": "maria@email.com",
  "clienteId": 1
}
```

**Respostas:**
- `201 Created` - Contato criado com sucesso
- `400 Bad Request` - Dados inválidos
- `404 Not Found` - Cliente não encontrado

## Estrutura do Projeto

```
├── src/main/java/
│   ├── controller/         
│   ├── service/            
│   ├── model/              
│   ├── dto/               
│   ├── mapper/             
│   ├── repository/        
│   └── config/             
├── src/main/resources/    
│   └── application.properties
├── src/test/java/          
└── README.md              
```

## Tecnologias Utilizadas

### Core Stack
- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **Spring Validation**
- **Maven**

### Database
- **PostgreSQL**
- **Docker** (para rodar o PostgreSQL)

### Utilities
- **Lombok**

---

Este projeto foi desenvolvido como parte de um desafio técnico para o Nubank.