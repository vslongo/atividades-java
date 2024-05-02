import java.util.ArrayList;
import java.util.List;

public class TarefaComposta implements Tarefa {

	private String titulo;
    private List<Tarefa> tarefas = new ArrayList<>();

    public TarefaComposta(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public void infoTarefa() {
        System.out.println("Título: " + titulo);
        for (Tarefa tarefa : tarefas) {
            tarefa.infoTarefa();
        }
    }

}
