public class Produto {
    String nome;
    double preco;
    int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public boolean vender(int quantidade) {
        if (quantidade > estoque) {
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco + " - Estoque: " + estoque;
    }
}
