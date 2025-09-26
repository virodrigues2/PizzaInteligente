// Arquivo: SistemaPizzaria.java
// Contém métodos para gerenciar pedidos, gerar relatórios e calcular frete
// Também inclui sugestões criativas de combinações de sabores

import java.util.*;

public class SistemaPizzaria {
    private List<Pedido> pedidos;  // Lista de todos os pedidos da pizzaria

    // Construtor: inicializa a lista de pedidos
    public SistemaPizzaria() {
        pedidos = new ArrayList<>();
    }

    // Adiciona um pedido à lista
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("✅ Pedido do " + pedido.getCliente() + " adicionado com sucesso!");
    }

    // ===== Método Alterar Pedido =====
    public void alterarPedido(int id) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = null;

        // Localiza o pedido pelo ID
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("❌ Pedido não encontrado!");
            return;
        }

        System.out.println("✅ Pedido encontrado: " + pedido);
        System.out.println("O que deseja fazer? Adicionar, remover ou alterar sabor da pizza? (add/rem/alter)");
        String acao = sc.nextLine();

        if (acao.equalsIgnoreCase("add")) {
            System.out.println("Digite o sabor da pizza:");
            String sabor = sc.nextLine();
            System.out.println("Digite o preço da pizza:");
            double preco = sc.nextDouble();
            sc.nextLine(); // limpar buffer
            pedido.adicionarPizza(new Pizza(sabor, preco));
        } else if (acao.equalsIgnoreCase("rem")) {
            System.out.println("Digite o sabor da pizza a remover:");
            String sabor = sc.nextLine();
            pedido.removerPizza(sabor);
        } else if (acao.equalsIgnoreCase("alter")) {
            System.out.println("Digite o sabor antigo:");
            String antigo = sc.nextLine();
            System.out.println("Digite o sabor novo:");
            String novo = sc.nextLine();
            pedido.alterarSaborPizza(antigo, novo);
