import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final List<Pizza> pizzaList;
    private List<Pizza> filteredList;

    // Construtor
    public Filter (List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
        this.filteredList = new ArrayList<>(pizzaList);
    }

    // Limpa o filtro
    public Filter cleanFilter() {
        this.filteredList = new ArrayList<>(this.pizzaList);
        return this;
    }

    // Inverte a filteredList
    public Filter reverseList() {
        Collections.reverse(this.filteredList);
        return this;
    }

    // Atribui a filteredList a Lista ordenada em ordem alfabetica por sabor
    public Filter orderByFlavor() {
        this.filteredList = this.filteredList.stream()
                .sorted(Comparator.comparing(Pizza::getFlavor))
                .collect(Collectors.toList());
        return this;
    }

    // Atribui a filteredList a Lista ordenada por tamanho (P -> M -> G)
    public Filter orderBySize() {
        this.filteredList = this.filteredList.stream()
                .sorted((p1, p2) -> {
                    int peso1 = (p1.getSize().equalsIgnoreCase("Small") || p1.getSize().equalsIgnoreCase("P")) ? 1 :
                            (p1.getSize().equalsIgnoreCase("Medium") || p1.getSize().equalsIgnoreCase("M")) ? 2 : 3;

                    int peso2 = (p2.getSize().equalsIgnoreCase("Small") || p2.getSize().equalsIgnoreCase("P")) ? 1 :
                            (p2.getSize().equalsIgnoreCase("Medium") || p2.getSize().equalsIgnoreCase("M")) ? 2 : 3;

                    return Integer.compare(peso1, peso2);
                })
                .collect(Collectors.toList());
        return this;
    }

    // Atribui a filteredList a Lista ordenada por preço crescente
    public Filter orderByPrice() {
        this.filteredList = this.filteredList.stream()
                .sorted(Comparator.comparing(Pizza::getPrice))
                .collect(Collectors.toList());
        return this;
    }

    // Filtra as pizzas com um sabor específico
    public Filter filterByFlavor (String Flavor) {
        this.filteredList = this.filteredList.stream()
                .filter(p -> p.getFlavor().equalsIgnoreCase(Flavor))
                .collect(Collectors.toList());
        return this;
    }

    // Filtra as Pizzas de um tamanho especifico
    public Filter filterBySize (String Size) {
        this.filteredList = this.filteredList.stream()
                .filter(p -> p.getSize().equalsIgnoreCase(Size))
                .collect(Collectors.toList());
        return this;
    }

    // Filtra as pizzas com no maximo um preço especifico
    public Filter filterByMaxPrice (float Price) {
        this.filteredList = this.filteredList.stream()
                .filter(p -> p.getPrice() <= Price)
                .collect(Collectors.toList());
        return this;
    }

    // Filtra as pizzas com no minimo um preço especifico
    public Filter filterByMinPrice (float Price) {
        this.filteredList = this.filteredList.stream()
                .filter(p -> p.getPrice() >= Price)
                .collect(Collectors.toList());
        return this;
    }

    public List<Pizza> getFilteredList() {
        return filteredList;
    }
}
