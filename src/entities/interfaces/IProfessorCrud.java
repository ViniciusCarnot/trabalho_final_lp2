package entities.interfaces;

import java.util.List;

import entities.dto.ProfessorDtoRequisicao;
import entities.dto.ProfessorDtoResposta;

public interface IProfessorCrud {
	
	ProfessorDtoResposta inserir(ProfessorDtoRequisicao dtoRequisicao);
	void deletar(String codigoFuncional);
	ProfessorDtoResposta atualizar(String codigoAtual, ProfessorDtoRequisicao dtoRequisicao);
	ProfessorDtoResposta ler(String codigoFuncional);
	List<ProfessorDtoResposta> lerTodos();
	
}
