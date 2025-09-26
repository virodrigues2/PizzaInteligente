import java.util.*;

public class SistemaPizzaria {

    private List<Pedido> pedidos;

    public SistemaPizzaria() {
        this.pedidos = new ArrayList<>();
    }

    // ===== Método para alterar pedido =====
    public void alterarPedido(int id) {
        Pedido pedidoAlterar = null;

        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedidoAlterar = p;
                break;
            }
        }

        if (pedidoAlterar == null) {
            System.out.println("❌ Pedido não encontrado.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nAlterar pedido do cliente: " + pedidoAlterar.getNomeCliente());
        System.out.println("1 - Adicionar pizza");
        System.out.println("2 - Remover pizza");
        System.out.println("3 - Alterar sabor de pizza");
        int opc = sc.nextInt();
        sc.nextLine(); // consumir a quebra de linha

        switch (opc) {
            case 1:
                System.out.print("Digite o sabor da pizza a adicionar: ");
                String saborAdd = sc.nextLine();
                System.out.print("Digite o preço da pizza: ");
                double precoAdd = sc.nextDouble();
                sc.nextLine();
                pedidoAlterar.adicionarPizza(new Pizza(saborAdd, precoAdd));
                System.out.println("✅ Pizza adicionada!");
                break;
            case 2:
                System.out.print("Digite o sabor da pizza a remover: ");
                String saborRem = sc.nextLine();
                pedidoAlterar.removerPizza(saborRem);
                break;
            case 3:
                System.out.print("Digite o sabor atual da pizza: ");
                String saborAntigo = sc.nextLine();
                System.out.print("Digite o novo sabor: ");
                String saborNovo = sc.nextLine();
                pedidoAlterar.alterarSaborPizza(saborAntigo, saborNovo);
                break;
            default:
                System.out.println("⚠️ Opção inválida.");
        }
    }

    // ===== Método para calcular frete =====
    public double calcularFrete(double distanciaKm, int quantidadePizzas) {
        double valorBase = 5.0;
        double taxaDistancia = distanciaKm * 0.5;
        double taxaQuantidade = quantidadePizzas > 5 ? (quantidadePizzas * 0.2) : 0;

        double frete = valorBase + taxaDistancia + taxaQuantidade;
        System.out.println("🚚 Valor do frete: R$" + frete);
        return frete;
    }

    // ===== Método para sugerir combinações =====
    public void sugerirCombinacoes(Pedido pedido) {
        System.out.println("\n💡 Sugestões de combinações para este pedido:");
        Map<String, Integer> combinacoes = new HashMap<>();

        for (Pedido p : pedidos) {
            if (p != pedido) {
                List<Pizza> lista = p.getPizzas();
                for (Pizza pi : lista) {
                    combinacoes.put(pi.getSabor(), combinacoes.getOrDefault(pi.getSabor(), 0) + 1);
                }
            }
        }

        combinacoes.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e -> System.out.println("   " + e.getKey() + " - popular entre outros pedidos"));
    }

    // ===== Método Gerar Relatório =====
    public void gerarRelatorio() {
        if (pedidos.isEmpty()) {
            System.out.println("⚠️ Nenhum pedido cadastrado ainda.");
            return;
        }

        Map<String, Integer> saborCount = new HashMap<>();      // Quantidade de cada sabor
        Map<String, Integer> grafoSabores = new HashMap<>();    // Combinações de sabores
        double faturamentoTotal = 0;

        for (Pedido p : pedidos) {
            List<Pizza> lista = p.getPizzas();

            // Somar preço das pizzas
            for (Pizza pi : lista) {
                faturamentoTotal += pi.getPreco();
                saborCount.put(pi.getSabor(), saborCount.getOrDefault(pi.getSabor(), 0) + 1);
            }

            // Criar grafo de combinações
            for (int i = 0; i < lista.size(); i++) {
                for (int j = i + 1; j < lista.size(); j++) {
                    String chave = lista.get(i).getSabor() + " ➔ " + lista.get(j).getSabor();
                    grafoSabores.put(chave, grafoSabores.getOrDefault(chave, 0) + 1);
                }
            }
        }

        // Exibir relatório
        System.out.println("\n📊 ===== RELATÓRIO DA PIZZARIA =====");
        System.out.println("💰 Faturamento total: R$ " + faturamentoTotal);

        // Sabores mais pedidos
        System.out.println("🔥 Sabores mais pedidos:");
        saborCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e -> System.out.println("   " + e.getKey() + " - " + e.getValue() + " pedidos"));

        // Conexões entre sabores
        System.out.println("🔗 Combinações de sabores mais populares:");
        grafoSabores.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e -> System.out.println("   " + e.getKey() + " - " + e.getValue() + " vezes"));
    }

    // ===== Método para adicionar pedidos =====
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // ===== Método para listar pedidos =====
    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("⚠️ Nenhum pedido cadastrado ainda.");
        } else {
            System.out.println("\n📋 Lista de pedidos:");
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }
}


