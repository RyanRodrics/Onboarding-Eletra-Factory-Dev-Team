import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lista de Pizzas Inicializada!\n");
        List<Pizza> pizzaList = List.of(
                new Pizza("Pepperoni", "Large", 19.99F),
                new Pizza("Margherita", "Medium", 15.50F),
                new Pizza("Four Cheese", "Large", 21.00F),
                new Pizza("Hawaiian", "Small", 13.75F),
                new Pizza("BBQ Chicken", "Medium", 18.25F),
                new Pizza("Vegetarian", "Large", 20.00F),
                new Pizza("Meat Lovers", "Large", 23.90F),
                new Pizza("Buffalo Chicken", "Medium", 19.00F),
                new Pizza("Supreme", "Large", 22.50F),
                new Pizza("Mushroom", "Small", 14.00F),
                new Pizza("Bacon", "Medium", 18.75F),
                new Pizza("Spinach Alfredo", "Large", 21.40F),
                new Pizza("Mexican", "Medium", 19.60F),
                new Pizza("Seafood", "Large", 24.90F),
                new Pizza("Cheese Burst", "Large", 23.00F),
                new Pizza("Garlic Chicken", "Medium", 18.90F),
                new Pizza("Tuna", "Small", 15.80F),
                new Pizza("Carbonara", "Medium", 20.30F),
                new Pizza("Pesto", "Small", 16.20F),
                new Pizza("Salami", "Large", 21.10F)
        );
        Filter f1 = new Filter(pizzaList);

        // Exemplo 1: Ordena por sabor, preço e tamanho, e filtra por preço máximo de $18.00 (Ativo)
        f1.orderByFlavor().orderByPrice().orderBySize().filterByMaxPrice(18F);

        // Exemplo 2: Filtra apenas pizzas do tamanho "Large" e ordena pelo preço mais barato
        // f1.cleanFilter().filterBySize("Large").orderByPrice();

        // Exemplo 3: Filtra pizzas com preço mínimo de $20.00 e ordena por sabor em ordem alfabética
        // f1.cleanFilter().filterByMinPrice(20F).orderByFlavor();

        // Exemplo 4: Busca uma pizza específica pelo sabor ("Pepperoni")
        // f1.cleanFilter().filterByFlavor("Pepperoni");

        // Exemplo 5: Ordena por preço do mais caro para o mais barato (ordena crescente e inverte)
        // f1.cleanFilter().orderByPrice().reverseList();

        System.out.println("--- Resultado ao aplicar o Filtro ---");
        f1.getFilteredList().forEach(p ->
                System.out.printf("Sabor: %-16s | Tamanho: %-6s | Preço: $%.2f%n",
                        p.getFlavor(), p.getSize(), p.getPrice())
        );
    }
}