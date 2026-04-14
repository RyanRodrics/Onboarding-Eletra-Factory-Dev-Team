# 📦 Onboarding Eletra - Endpoint 1: Gestão de Caixas (Energy.Box)

Este projeto foi inicializado utilizando o **Spring Initializr** e faz parte das atividades práticas complementares de onboarding da equipa de desenvolvimento de Sistemas de Fábrica da Eletra. O objetivo é desenvolver uma API robusta para a gestão de caixas de medidores, integrando-se diretamente ao banco de dados de homologação da empresa.

## 🚀 O Desafio

O foco técnico deste exercício foi a implementação do **Endpoint 1**: um CRUD completo para a entidade `Energy.Box`, com os seguintes diferenciais:
* **Integração Real:** Conexão direta com o Microsoft SQL Server (Ambiente de Homologação).
* **Dados Aninhados:** No método `GET`, as caixas retornam automaticamente a lista de medidores vinculados (`boxMeters`).
* **Paginação Dinâmica:** Suporte nativo para controle de tamanho de página e ordenação via parâmetros de URL.
* **Segurança de Credenciais:** Implementação de suporte a variáveis de ambiente para proteção de dados sensíveis.

## 🛠️ Stack Tecnológica

* **Linguagem:** Java (v17+)
* **Framework:** Spring Boot (Iniciado via Spring Initializr)
* **ORM:** Spring Data JPA / Hibernate
* **Banco de Dados:** Microsoft SQL Server
* **Gestão de Dependências:** Maven

## 📂 Estrutura do Projeto

* **`controllers/`**: Gestão das rotas REST e parâmetros de entrada.
* **`services/`**: Camada de lógica de negócio e conversão de Entidades para DTOs.
* **`repositories/`**: Interfaces de comunicação com o SQL Server.
* **`models/entities/`**: Mapeamento das tabelas `Box` e `BoxMeters`.
* **`models/dto/`**: Records para transferência de dados segura e formatada no JSON.

## ⚙️ Como Executar a Aplicação

Este projeto foi configurado para ser totalmente portátil, permitindo que qualquer desenvolvedor o execute sem a necessidade de instalar o Maven manualmente ou configurar plugins de IDE.

### 1. Configurar Variáveis de Ambiente
Para proteger as credenciais do banco de dados, o projeto utiliza um ficheiro `.env`.
* Crie um ficheiro chamado `.env` na raiz do projeto, seguindo o exemplo contido em `.env.example`.

### 2. Executar via Maven Wrapper
Utilize os comandos abaixo no terminal para descarregar as dependências e subir a API automaticamente:

* **No Windows:**
    mvnw.cmd spring-boot:run

* **No Linux/Mac:**
    ./mvnw spring-boot:run

A API estará disponível em `http://localhost:8080/api/boxes`.

## 📡 Documentação dos Endpoints

### Listagem com Paginação (GET)
Exemplo de busca da terceira página, com 5 itens, ordenados pelo ID mais recente:
`GET /api/boxes?page=2&size=5&sort=id,desc`

### Busca por ID (GET)
`GET /api/boxes?id=10` (Retorna a caixa dentro da estrutura de página para manter o padrão do JSON).

### CRUD Completo
* **POST /api/boxes**: Criação de novos registros.
* **PUT /api/boxes/{id}**: Atualização de dados existentes.
* **DELETE /api/boxes/{id}**: Remoção de registros.
