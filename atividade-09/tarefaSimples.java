public class TarefaSimples implements Tarefa{
	private String titulo;
    private String descricao;
    private String prazo;

    public TarefaSimples(String titulo, String descricao, String prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
    }

    @Override
    public void infoTarefa() {
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Prazo: " + prazo);
    }
}
