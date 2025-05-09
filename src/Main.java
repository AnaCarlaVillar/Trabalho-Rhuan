import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {

        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.FINE);
        for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
            handler.setLevel(Level.FINE);
        }
    }

    public static void main(String[] args) {
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Loja de Roupas ---");
            loja.listarProdutos();
            System.out.print("Digite o número do produto que deseja comprar (ou -1 para sair): ");
            int escolha = scanner.nextInt();

            if (escolha == -1) {
                logger.info("Aplicação encerrada.");
                break;
            }

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();

            loja.realizarVenda(escolha, quantidade);
        }
    }
}
