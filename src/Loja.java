import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loja {
    private static final Logger logger = Logger.getLogger(Loja.class.getName());
    private final List<Produto> produtos = new ArrayList<>();

    public Loja() {
        logger.info("Loja iniciada.");
        // Produtos pré-cadastrados
        produtos.add(new Produto("Camiseta", 59.90, 10));
        produtos.add(new Produto("Calça Jeans", 129.90, 5));
        produtos.add(new Produto("Jaqueta", 199.90, 3));
    }

    public void listarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(i + " - " + produtos.get(i));
        }
    }

    public boolean realizarVenda(int indiceProduto, int quantidade) {
        if (indiceProduto < 0 || indiceProduto >= produtos.size()) {
            logger.warning("Índice de produto inválido: " + indiceProduto);
            return false;
        }

        Produto produto = produtos.get(indiceProduto);
        logger.fine("Tentativa de venda: " + produto.nome + " x" + quantidade);

        if (produto.vender(quantidade)) {
            double total = quantidade * produto.preco;
            logger.info("Venda realizada: " + produto.nome + " x" + quantidade + " (Total: R$" + total + ")");
            System.out.println("Venda realizada! Total: R$" + total);
            return true;
        } else {
            logger.warning("Estoque insuficiente para " + produto.nome);
            System.out.println("Estoque insuficiente.");
            return false;
        }
    }
}
