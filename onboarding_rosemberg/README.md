# 🏭 Onboarding Complementar - P&D Sistemas de Fábrica (Rosemberg)

Este diretório contém a resolução das atividades práticas de SQL e Backend propostas como complemento ao onboarding padrão da Eletra Energy Solutions. O foco destas tarefas é a manipulação de dados reais de produção, rastreabilidade de medidores e integração entre sistemas legados.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17+ (Inicializado via Spring Initializr)
* **Framework:** Spring Boot 3.x
* **ORM:** Spring Data JPA / Hibernate
* **Banco de Dados:** Microsoft SQL Server (Homologação)
* **Segurança:** Dotenv-Java (Gestão de variáveis de ambiente)

---


---

## 📊 Atividades de SQL

## 1. Relatório de Ordens de Produção (OP) por Lote

Gerar um SQL que retorne as informações sobre a OP, com uma linha para cada lote.

- **Campos requeridos:**
    
    - OP
        
    - Lote
        
    - Quantidade do Lote
        
    - Quantidade de caixas do lote
        
    - Peso bruto do caixa
        
    - Número Eletra Inicial / Final
        
    - Número Cliente Inicial / Final
        

## 2. Rastreabilidade do Medidor (Status de Etapas)

Gerar um SQL que retorne o status das etapas de um medidor através do seu **Número Eletra**. Deve apresentar a data de realização ou vazio caso não tenha sido concluída.

- **Etapas a monitorar:**
    
    - Impressão Laser
        
    - Endereçamento
        
    - Casamento do NIC
        
    - Teste do LED
        
    - Embalagem
        
    - Fechamento da caixa
        

## 3. Histórico da PCBA (EletraDB)

Gerar um SQL que retorne o histórico completo de todas as etapas em que a PCBA passou, ordenadas por data.

- **Informações:** Data, Etapa, Usuário, Sucesso (Sim/Não), Cancelado (Sim/Não) e Número Eletra associado.

- **Etapas a incluir:** Embalagem SMT/PTH, Montagem Inicial, Tensão Aplicada, Configuração de Parâmetros, Verificação, Endereçamento, Casamento do NIC, Teste do LED, Embalagem e Reparo.

---

## 💻 Atividades de Código (Backend)

**Requisitos Gerais:**

- **Linguagem:** Java ou C#.
    
- **Tecnologias:** REST API, SQL Server, Bibliotecas de ORM/Acesso a dados, Conversão de DTOs.
    
- **Critérios:** Organização de código, separação de responsabilidades e rodar em ambiente local.
    

## Endpoint 1: Gestão de Caixas (Energy.Box)

- **Funcionalidade:** CRUD completo com suporte a **paginação**.
    
- **Detalhe:** No método `GET`, as informações das caixas devem vir acompanhadas de seus respectivos medidores vinculados.
    

## Endpoint 2: Detalhes da OP de Montagem

- **Funcionalidade:** Endpoint de `GET` para retornar informações de uma OP (conforme a tela "Detalhes da OP").
    
- **Integração:** Apresentar a quantidade produzida em cada etapa (de acordo com o Template do PIMS).
    
- **Nota Técnica:** O acesso ao banco **Oracle** deve ser feito via `OpenQuery` diretamente através de uma transação no **SQL Server**.`



---