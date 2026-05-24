package entities.interfaces;

import java.util.List;

import entities.Curso;
import entities.dto.CursoDto;

public interface ICursoCrud {

	CursoDto inserir(Curso curso);
	void deletar(Integer id);
	CursoDto atualizar(Curso curso);
	CursoDto ler(Integer id);
	List<CursoDto> lerTodos();
	
}
