import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String telefone;

    public Pessoa(String nome, String sobrenome, String dataNascimento, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    // metodo de comparacao
    @Override
    public int compareTo(Pessoa outraPessoa) {
        // compra o nome
        int compareNome = this.nome.compareTo(outraPessoa.nome);
        if (compareNome != 0) {
            return compareNome;
        }
        
        // se o nome igual comparo o sobrenome
        int compareSobrenome = this.sobrenome.compareTo(outraPessoa.sobrenome);
        if (compareSobrenome != 0) {
            return compareSobrenome;
        }

        return this.dataNascimento.compareTo(outraPessoa.dataNascimento);
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " - Nascimento: " + dataNascimento + ", Tel: " + telefone;
    }

    public static void main(String[] args) {
        // Instanciando objetos Pessoa
        Pessoa pessoa1 = new Pessoa("Vinicius", "Slongo", "2003-08-05", "123456789");
        Pessoa pessoa2 = new Pessoa("Thiago", "Trzcinski", "1985-10-20", "987654321");
        Pessoa pessoa3 = new Pessoa("Fabio", "Pinheiro", "1410-03-10", "456789123");

        // Criando uma coleção de pessoas
        List<Pessoa> agenda = new ArrayList<>();
        agenda.add(pessoa1);
        agenda.add(pessoa2);
        agenda.add(pessoa3);

        // antes de ordenar
        System.out.println("Conteúdo da coleção antes da ordenação:");
        for (Pessoa pessoa : agenda) {
            System.out.println(pessoa);
        }

        // aqui ordena
        Collections.sort(agenda);

        // imprime depois de ordenar
        System.out.println("\nConteúdo da coleção após a ordenação:");
        for (Pessoa pessoa : agenda) {
            System.out.println(pessoa);
        }
    }
}
