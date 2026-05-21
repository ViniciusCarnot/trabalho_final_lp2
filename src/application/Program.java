package application;

import java.time.LocalDate;

import entities.IFuncoesCrud;
import entities.Professor;
import entities.ProfessorDao;

public class Program {

	public static void main(String[] args) {
		
		// Teste: Inserção professor
		
		Professor p1 = new Professor(null, "PCP111", "Alberto Alves", LocalDate.of(1980, 1, 1));
		
		IFuncoesCrud<Professor> op1 = new ProfessorDao();
		op1.inserir(p1);
	}

}
