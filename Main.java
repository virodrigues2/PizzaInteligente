// Arquivo: Main.java
// Classe principal para rodar o sistema da Pizzaria Criativa

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaPizzaria sistema = new SistemaPizzaria();
        Scanner sc = new Scanner(System.in);

        // ===== Criando pedidos de teste =====
        Pedido p1 = new Pedido(1, "João");
        p1.adicionarPizza(new Pizza("Margherita", 30));
        p1.adicionarPizza(new Pizza("Pepperoni", 35));
        sistema.adicionarPedido(p1);

        Pedido p2 = new Pedido(2, "Maria");
        p2.adicionarPizza(new Pizza("Calabresa", 32));
        sistema.adicionarPedido(p2);

        System.out.println("\n🍕 ===== SISTEMA DE PIZZARIA =====");

        boolean rodando = true;
        while (rodando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Alterar pedido");
            System.out.println("2 - Gerar relatório");
            System.out.println("3 - Calcular frete");
            System.out.println("4 - Sugerir combinações");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do pedido que deseja alterar:");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    sistema.alterarPedido(id);
                    break;
                case 2:
                    sistema.gerarRelatorio();
                    break;
                case 3:
                    System.out.println("Digite a distância até o cliente (km):");
                    double km = sc.nextDouble();
                    System.out.println("Digite a quantidade de pizzas do pedido:");
                    int qtd = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    sistema.calcularFrete(km, qtd);
                    break;
                case 4:
                    System.out.println("Digite o ID do pedido para sugestões de combos:");
                    int idSug = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    Pedido pedidoSug = null;
                    for (Pedido p : sistema.pedidos) {
                        if (p.getId() == idSug) {
                            pedidoSug = p;
                            break;
                        }
                    }
                    if (pedidoSug != null) {
                        sistema.sugerirCombinacoes(pedidoSug);
                    } else {
                        System.out.println("❌ Pedido não encontrado!");
                    }
                    break;
                case 0:
                    rodando = false;
                    System.out.println("👋 Obrigada por usar a Pizzaria Criativa!");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }
}
