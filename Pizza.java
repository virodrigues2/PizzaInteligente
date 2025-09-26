// Arquivo: Pizza.java
// Representa uma pizza do pedido da pizzaria
// Aqui definimos o sabor e o preço de cada pizza

public class Pizza {
    // Variáveis de instância
    private String sabor;  // Nome do sabor da pizza
    private double preco;  // Preço da pizza

    // Construtor: usado para criar uma nova pizza
    public Pizza(String sabor, double preco) {
        this.sabor = sabor;
        this.preco = preco;
    }

    // Getter do sabor
    public String getSabor() {
        return sabor;
    }

    // Setter do sabor (para alterar o sabor se necessário)
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    // Getter do preço
    public double getPreco() {
        return preco;
    }

    // Método para mostrar a pizza de forma amigável
    @Override
    public String toString() {
        return sabor + " (R$" + preco + ")";
    }
}
