package entities.interfaces;

import java.util.List;

import entities.Professor;
import entities.dto.ProfessorDto;

public interface IProfessorCrud {
	
	ProfessorDto inserir(Professor professor);
	void deletar(Integer id);
	ProfessorDto atualizar(Professor professor);
	ProfessorDto ler(Integer id);
	List<ProfessorDto> lerTodos();
	
}
