# Exercício 2: SQL Básico 💾

Este diretório contém a resolução do segundo exercício do onboarding da Eletra. O foco é demonstrar a proficiência em operações fundamentais de bancos de dados relacionais utilizando PostgreSQL.

## 🔗 Integração com o Exercício 3

Para criar um cenário de negócio real e coeso, a resolução deste exercício foi construída **sobre o banco de dados `onboarding_ex_03_db`**, configurado no Exercício 3. 

Enquanto o Exercício 3 foca na alta performance das métricas (Time-Series) na tabela `sensor_data`, este Exercício 2 foca no **lado relacional** do sistema: criamos uma tabela de metadados (`sensors`) e demonstramos como cruzar dados relacionais estáticos com métricas temporais dinâmicas através de `JOINs`.

## 🗂️ Estrutura do Diretório

Os scripts SQL foram divididos por responsabilidade para simular um fluxo real de migração de banco de dados:

* `sql/01_schema.sql` (DDL): Criação da estrutura da tabela de metadados dos sensores.
* `sql/02_inserts.sql` (DML): Inserção (Seed) dos dados que representam o cadastro físico dos 10 sensores na fábrica.
* `sql/03_queries.sql` (DQL): Consultas com filtros básicos (`WHERE`, `LIKE`, `ORDER BY`) e operações avançadas de relacionamento (`JOIN`, subqueries) unindo os dados do Exercício 2 com os do Exercício 3.

## 🚀 Como Executar

1. Certifique-se de que o contêiner do TimescaleDB (criado no Exercício 3) está rodando.
2. Conecte-se ao banco de dados `onboarding_ex_03_db`.
3. Execute os scripts da pasta `sql/` em ordem numérica (01, depois 02, depois 03) para criar a tabela, populá-la e ver os relatórios gerados.