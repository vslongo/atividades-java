public class main {
	public static void main(String[] args) {
		Tarefa tarefa1 = new TarefaSimples("Atividade Adapter", "Fazer para o Fabao", "21/04/2024");
        Tarefa tarefa2 = new TarefaSimples("Atividade Composite", "Fazer para o Fabao", "21/04/2024");
        Tarefa tarefa3 = new TarefaSimples("Atividade Decorator", "Fazer para o Fabao", "21/04/2024");
        
        Tarefa tarefaComposta1 = new TarefaComposta("Decorator e composite");
        ((TarefaComposta) tarefaComposta1).adicionarTarefa(tarefa2);
        ((TarefaComposta) tarefaComposta1).adicionarTarefa(tarefa3);

        Tarefa tarefaComposta2 = new TarefaComposta("Atividade pro Fabao");
        ((TarefaComposta) tarefaComposta2).adicionarTarefa(tarefaComposta1);
        ((TarefaComposta) tarefaComposta2).adicionarTarefa(tarefa3);
    
        tarefaComposta2.infoTarefa();
	}
}
