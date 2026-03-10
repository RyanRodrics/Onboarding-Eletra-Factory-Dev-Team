# Eletra Onboarding - Sistemas de Fábrica 🏭

Este repositório contém as resoluções dos exercícios práticos do processo de onboarding da equipe de desenvolvimento de Sistemas de Fábrica da Eletra Energy Solutions.

O objetivo desta trilha é proporcionar uma familiarização prática com a stack de tecnologias, arquitetura e padrões utilizados no dia a dia da equipe.

O documento original que serve como base para todos estes exercícios, [Factory systems - onboarding.pdf](./Factory%20systems%20-%20onboarding.pdf), encontra-se disponível na raiz deste repositório para consulta.

## 🛠️ Stack Tecnológica

Ao longo dos exercícios, as seguintes tecnologias e conceitos são explorados:

* **Backend:** Java (v8 e v17), Spring Framework, Spring Boot, RESTful APIs.
* **Frontend:** Vue.js / Vue 3+.
* **Banco de Dados:** SQL, TimescaleDB, Flyway.
* **Mensageria e Cache:** Redis.
* **Infraestrutura e DevOps:** Docker, GitLab CI.
* **Testes:** TestContainers, Testes de Integração.
* **Arquitetura e Resiliência:** Microserviços, Resilience4j, OpenFeign.

## 📁 Estrutura do Repositório

A resolução foi dividida em diretórios independentes para cada exercício proposto no documento. Cada pasta possui seu próprio `README.md` com os detalhes de implementação e instruções de execução.

| Diretório | Tópico | Descrição Resumida |
| :--- | :--- | :--- |
| [`/ex1`](./ex1) | **Java (v8 e v17)** | Uso de expressões lambda para filtragem e ordenação de listas. |
| [`/ex2`](./ex2) | **SQL Básico** | Criação de tabelas, inserção de dados e consultas com filtros e junções. |
| [`/ex3`](./ex3) | **TimescaleDB** | Criação e consulta de um banco de dados de séries temporais para sensores. |
| [`/ex4`](./ex4) | **RESTful API** | Desenvolvimento de uma API Spring Boot para gerenciamento de chamados. |
| [`/ex5`](./ex5) | **TestContainers** | Implementação de testes de integração para a API do exercício 4. |
| [`/ex6`](./ex6) | **GitLab CI** | Configuração de um pipeline básico de compilação e testes. |
| [`/ex7`](./ex7) | **Docker** | Dockerização da API RESTful de chamados. |
| [`/ex8`](./ex8) | **Microserviços** | Divisão do sistema em dois serviços: gerenciamento de chamados e de usuários. |
| [`/ex9`](./ex9) | **Redis** | Implementação de caching para otimizar as consultas no sistema de chamados. |
| [`/ex10`](./ex10) | **Vue.js 3+** | Construção de uma interface web para interagir com a API do sistema. |
| [`/ex-extra-1`](./ex-extra-1) | **Resilience4j** | Implementação de tolerância a falhas (retries e circuit breakers). |
| [`/ex-extra-2`](./ex-extra-2) | **OpenFeign** | Configuração de clientes HTTP para comunicação entre microserviços. |

## 🚀 Como Executar

Para instruções específicas de como rodar cada aplicação, configurar bancos de dados ou subir os containers Docker, por favor, consulte o `README.md` localizado dentro da pasta correspondente ao exercício de interesse.
