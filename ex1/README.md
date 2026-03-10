# Exercício 1: Java (Versões 8 e 17) ☕

Este diretório contém a resolução do primeiro exercício do onboarding.

O objetivo deste exercício é criar uma aplicação Java simples que demonstre o uso de expressões lambda (Java 8) e as melhorias de desempenho da versão 17. A tarefa consiste em desenvolver um programa que filtre e ordene uma lista de objetos usando expressões lambda.

Para resolver isso, foi criada uma aplicação de gerenciamento e filtragem de um cardápio de Pizzas, utilizando a API de Streams do Java (`java.util.stream`) e Expressões Lambda para encadear filtros de sabor, tamanho e preço de forma fluida.

## 🗂️ Estrutura do Código

* `Pizza.java`: Classe de modelo (POJO) que representa uma pizza com os atributos `flavor` (sabor), `size` (tamanho) e `price` (preço).
* `Filter.java`: Classe responsável pela lógica de negócio. Contém os métodos que utilizam Streams e Lambdas para ordenar e filtrar a lista de pizzas.
* `Main.java`: Ponto de entrada da aplicação. Inicializa a lista de pizzas e demonstra a aplicação de múltiplos filtros encadeados. Dentro deste ficheiro, **há vários exemplos comentados** de diferentes combinações de filtros. Pode descomentá-los para testar ou encadear os métodos para criar as suas próprias consultas!

## 🚀 Como executar

Você pode rodar este projeto de duas maneiras:

### Opção 1: Usando uma IDE (IntelliJ IDEA)
1. Importe a pasta `ex1` no seu editor.
2. Navegue até `src/Main.java`.
3. Execute o método `main`. A saída será exibida na consola da IDE.

### Opção 2: Usando a Linha de Comando (Terminal)
Caso prefira rodar diretamente no terminal, certifique-se de ter o JDK 17 (ou superior) instalado.

1. Navegue até à pasta `src`:
   ```bash
   cd ex1/src


2. Compile os ficheiros .java:

   ```bash
   javac *.java
   
3. Execute a classe principal:
   ```bash
   java Main
