package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
