// Arquivo: Pedido.java
// Representa um pedido do cliente na pizzaria
// Cada pedido pode ter várias pizzas e possui ID e nome do cliente

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;              // ID único do pedido
    private String cliente;      // Nome do cliente
    private List<Pizza> pizzas;  // Lista de pizzas do pedido

    // Construtor: cria um novo pedido com ID e nome do cliente
    public Pedido(int id, String cliente) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = new ArrayList<>();
    }

    // Getter do ID
    public int getId() {
        return id;
    }

    // Getter do nome do cliente
    public String getCliente() {
        return cliente;
    }

    // Getter da lista de pizzas
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    // Adiciona uma pizza ao pedido
    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        System.out.println("🍕 Pizza " + pizza.getSabor() + " adicionada ao pedido do " + cliente + "!");
    }

    // Remove uma pizza do pedido pelo sabor
    public void removerPizza(String sabor) {
        boolean removed = pizzas.removeIf(p -> p.getSabor().equalsIgnoreCase(sabor));
        if (removed) {
            System.out.println("🗑️ Pizza " + sabor + " removida do pedido do " + cliente + "!");
        } else {
            System.out.println("⚠️ Pizza " + sabor + " não encontrada no pedido do " + cliente + "!");
        }
    }

    // Alterar o sabor de uma pizza no pedido
    public void alterarSaborPizza(String saborAntigo, String saborNovo) {
        boolean encontrado = false;
        for (Pizza p : pizzas) {
            if (p.getSabor().equalsIgnoreCase(saborAntigo)) {
                p.setSabor(saborNovo);
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("🔄 Sabor alterado de " + saborAntigo + " para " + saborNovo + " no pedido do " + cliente + "!");
        } else {
            System.out.println("⚠️ Sabor " + saborAntigo + " não encontrado no pedido do " + cliente + "!");
        }
    }

    // Mostra o pedido de forma amigável
    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Cliente: " + cliente + ", Pizzas: " + pizzas;
    }
}
