# Exercício 3: TimescaleDB ⏱️

Este diretório contém a resolução do terceiro exercício do onboarding da Eletra. 

O objetivo é criar e configurar um banco de dados de séries temporais (Time-Series) focado em alta performance para armazenamento de dados de sensores industriais. Toda a configuração, modelagem e queries de análise foram baseadas nas boas práticas e no [Readme do repositório oficial do TimescaleDB](https://github.com/timescale/timescaledb).

## 🗂️ Estrutura do Diretório

* `docker-compose.yml`: Arquitetura do banco de dados utilizando a imagem oficial do TimescaleDB (baseada no PostgreSQL 15).
* `sql/`: Diretório contendo os scripts SQL divididos em etapas lógicas para facilitar a reprodução do ambiente.

## 🚀 Como reproduzir este ambiente na sua máquina

Para testar as funcionalidades deste exercício, siga o passo a passo abaixo.

### Pré-requisitos
* Docker e Docker Compose instalados e rodando (com suporte a *Linux Containers*).
* Um cliente de banco de dados SQL (ex: DataGrip, DBeaver ou pgAdmin).

### Passo 1: Subir o Banco de Dados
Abra o terminal na raiz desta pasta (`ex3`) e execute o comando para baixar e iniciar o contêiner em segundo plano:

```bash
docker compose up -d
```

### Passo 2: Conectar ao Banco
Abra o seu cliente SQL e crie uma nova conexão PostgreSQL com as seguintes credenciais:
* **Host:** `localhost`
* **Porta:** `5432`
* **Usuário:** `postgres`
* **Senha:** `postgres`
* **Database:** `onboarding_ex_03_db`

### Passo 3: Executar os Scripts SQL (Setup, Seed e Análises)
Dentro do seu cliente SQL, abra uma aba de *Query Console* apontando para o banco `onboarding_ex_03_db` e execute os arquivos da pasta `sql/` na seguinte ordem (que reflete o fluxo de arquitetura recomendado pelo repositório oficial):

1. **`01_setup.sql`**: Cria a extensão do Timescale, a tabela base e a converte em uma **Hypertable** (particionada automaticamente pelo tempo). Também cria o índice composto exigido para Time-Series (`sensor_id`, `time DESC`).
2. **`02_seed_and_compress.sql`**: Habilita a compressão colunar (Columnstore) agrupada por sensor. Insere milhares de registros simulados ao longo dos últimos 7 dias e, por fim, força a reordenação e compressão dos *chunks* em disco.
3. **`03_continuous_aggregates.sql`**: Cria uma *Continuous Aggregate* (Materialized View otimizada) com políticas automáticas para pré-calcular dados de hora em hora, economizando poder de processamento em dashboards.
4. **`04_analysis_queries.sql`**: Contém as consultas analíticas de extração de valor. Explora funções exclusivas como o `time_bucket()` para agrupar janelas de tempo, calculando médias e picos em milissegundos mesmo sobre dados comprimidos.

### Passo 4: Limpeza (Clean up)
Ao finalizar os testes de carga e análise, você pode parar e destruir o contêiner, além de apagar o volume de dados do seu disco rígido, executando o comando abaixo no terminal da pasta `ex3`:

```bash
docker compose down -v
```