package entities.interfaces;

import java.util.List;

public interface IFuncoesCrud<E> {

	void inserir(E entidade);
	void deletar(Integer id);
	void atualizar(E entidade);
	E ler(Integer id);
	List<E> lerTodos();
	
}
