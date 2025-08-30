package com.exemplo.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.demorest.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
