package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import model.Tarefa;
import repository.TarefaRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	// lista todas as tarefas 
	@GetMapping
	public List<Tarefa> listarTodas() {
		return tarefaRepository.findAll();		
	}
	
	// busca as tarefas por Id
	@GetMapping("/{id}")
	public Optional<Tarefa> buscarPorId(@PathVariable Long id) {
		return tarefaRepository.findById(id);
	}
	
	// cria uma nova tarefa
	@PostMapping
	public Tarefa criar(@RequestBody Tarefa tarefa) {
		return tarefaRepository.save(tarefa);		
	}
	
	// atualiza uma tarefa existente
	@PutMapping("/{id}")
	public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
		return tarefaRepository.findById(id).map(tarefa -> {
			tarefa.setNome(tarefaAtualizada.getNome());
			tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
			tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
			return tarefaRepository.save(tarefa);
		}).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id" + id));
	} 
	
	
	//deletar tarefa
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		tarefaRepository.deleteById(id);
	}
}




