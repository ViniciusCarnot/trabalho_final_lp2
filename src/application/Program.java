package application;

import java.time.LocalDate;
import java.util.List;

import entities.IFuncoesCrud;
import entities.Professor;
import entities.ProfessorDao;

public class Program {

	public static void main(String[] args) {
		
		// Teste: Inserção professor
		/*
		Professor p1 = new Professor(null, "PCP111", "Alberto Alves", LocalDate.of(1980, 1, 1));
		
		IFuncoesCrud<Professor> op1 = new ProfessorDao();
		op1.inserir(p1);
		 */

		/*
		Professor p2 = new Professor(1, "PCP222", "Bruno Bisca", LocalDate.of(1981, 1, 1));
		
		IFuncoesCrud<Professor> op2 = new ProfessorDao();

		op2.atualizar(p2);
		*/

		/*
		IFuncoesCrud<Professor> op3 = new ProfessorDao();

		Professor p3 = op3.ler(1);
		System.out.println(p3);
		*/

		/*
		Professor p4 = new Professor(null, "PCP333", "Liminha", LocalDate.of(1982, 9, 5));

		IFuncoesCrud<Professor> op4 = new ProfessorDao();
		op4.inserir(p4);
		*/

		/*
		IFuncoesCrud<Professor> op5 = new ProfessorDao();
		List<Professor> lp = op5.lerTodos();
		for(Professor p : lp){
			System.out.println(p);
		}
		*/

		IFuncoesCrud<Professor> op6 = new ProfessorDao();
		op6.deletar(1); 
	}

}
