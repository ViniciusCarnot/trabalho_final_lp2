package entities.interfaces;

import java.util.List;

import entities.dto.CursoDtoRequisicao;
import entities.dto.CursoDtoResposta;

public interface ICursoCrud {

	CursoDtoResposta inserir(CursoDtoRequisicao dtoRequisicao);
	void deletar(String codigo);
	CursoDtoResposta atualizar(String codigo, CursoDtoRequisicao dtoRequisicao);
	CursoDtoResposta ler(String codigo);
	List<CursoDtoResposta> lerTodos();
	
}
