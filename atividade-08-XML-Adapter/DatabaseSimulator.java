import java.util.ArrayList;
import java.util.List;

public class DatabaseSimulator {

    private static List<String> items = new ArrayList<>();

    public static void insertData(String nome, double preco) {
        String item = "Item: " + nome + " | Preço: " + preco;
        items.add(item);
        System.out.println("Dados inseridos no banco de dados simulado: " + item);
    }

    public static void showDatabaseContent() {
        System.out.println("Conteúdo do banco de dados simulado:");
        for (String item : items) {
            System.out.println(item);
        }
    }
}
