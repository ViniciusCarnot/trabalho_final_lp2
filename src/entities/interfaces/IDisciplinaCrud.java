package entities.interfaces;

import java.util.List;

import entities.dto.DisciplinaDtoRequisicao;
import entities.dto.DisciplinaDtoResposta;

public interface IDisciplinaCrud {
	
	DisciplinaDtoResposta inserir(DisciplinaDtoRequisicao dtoRequisicao);
	DisciplinaDtoResposta atualizar(Integer numero, DisciplinaDtoRequisicao dtoRequisicao);
	DisciplinaDtoResposta ler(Integer numero);
	List<DisciplinaDtoResposta> lerTodos();
	void deletar(Integer numero);

}
