package entities.interfaces;

import java.util.List;

import entities.Disciplina;
import entities.dto.DisciplinaDtoResposta;
import entities.dto.DisciplinaDtoRequisicao;

public interface IDisciplinaCrud {
	
	DisciplinaDtoResposta inserir(DisciplinaDtoRequisicao dtoRequisicao);
	DisciplinaDtoResposta atualizar(Integer numero, DisciplinaDtoRequisicao dtoRequisicao);
	DisciplinaDtoResposta ler(Integer numero);
	List<DisciplinaDtoResposta> lerTodos();
	void deletar(Integer numero);

}
