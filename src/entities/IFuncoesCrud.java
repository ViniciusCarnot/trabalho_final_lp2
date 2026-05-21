package entities;

public interface IFuncoesCrud<E> {

	void inserir(E entidade);
	void deletar(Integer id);
	void atualizar(E entidade);
	void ler(Integer id);
	void lerTodos();
	
}
