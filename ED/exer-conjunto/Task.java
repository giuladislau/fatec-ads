import java.util.Objects;

// classe que representa uma tarefa individual
public class Task {
    private int id;
    private String descricao;

    // construtor para inicializar a tarefa
    public Task(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // getters para acessar os atributos da tarefa
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    // redefine o método equals para considerar tarefas iguais pelo id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id;
    }

    // redefine o método hashCode para manter a consistência com equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // representação textual da tarefa
    @Override
    public String toString() {
        return "Task{id=" + id + ", descricao='" + descricao + "'}";
    }
}
