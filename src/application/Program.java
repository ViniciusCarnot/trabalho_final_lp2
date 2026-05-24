package application;

import java.time.LocalDate;
import java.util.List;

import entities.Curso;
import entities.Disciplina;
import entities.Professor;
import entities.dao.CursoDao;
import entities.dao.DisciplinaDao;
import entities.dao.ProfessorDao;
import entities.dto.DisciplinaDtoRequisicao;
import entities.dto.DisciplinaDtoResposta;
import entities.interfaces.IDisciplinaCrud;
import entities.interfaces.IFuncoesCrud;

public class Program {

	public static void main(String[] args) {
		
		/// TESTE: INSERIR PROFESSOR
		/*
		Professor p1 = new Professor(null, "PCP111", "Alberto Alves", LocalDate.of(1980, 1, 1));
		
		IFuncoesCrud<Professor> op1 = new ProfessorDao();
		op1.inserir(p1);
		 */

		/// TESTE: ATUALIZAR PROFESSOR
		/*
		Professor p2 = new Professor(1, "PCP222", "Bruno Bisca", LocalDate.of(1981, 1, 1));
		
		IFuncoesCrud<Professor> op2 = new ProfessorDao();

		op2.atualizar(p2);
		*/

		/// TESTE: LER PROFESSOR
		/*
		IFuncoesCrud<Professor> op3 = new ProfessorDao();

		Professor p3 = op3.ler(1);
		System.out.println(p3);
		*/

		/// TESTE: LER PROFESSORES
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

		/// TESTE: DELETAR PROFESSOR
		/*
		IFuncoesCrud<Professor> op6 = new ProfessorDao();
		op6.deletar(1); 
		*/
		
		/// TESTE: INSERIR CURSO
		/*
		Curso c1 = new Curso(null, "PCENGCOMP", "Engenharia da Computação", "...", LocalDate.of(2024,  2, 1), 
				LocalDate.of(2027, 12, 1));
				
		IFuncoesCrud<Curso> op7 = new CursoDao();
		op7.inserir(c1);
		*/
		
		/// TESTE: ATUALIZAR CURSO
		/*
		Curso c2 = new Curso(1, "PCENGMEC", "Engenharia Mecânica", "Curso destinado a montagem e manutenção de peças.", 
				LocalDate.of(2024,  2, 1), LocalDate.of(2027, 12, 1));
		
		IFuncoesCrud<Curso> op8 = new CursoDao();
		op8.atualizar(c2);
		*/
		
		/// TESTE: LER CURSO
		/*
		IFuncoesCrud<Curso> op9 = new CursoDao();
		System.out.println(op9.ler(1));
		*/
		
		/// TESTE: LER CURSOS
		/*
		IFuncoesCrud<Curso> op10 = new CursoDao();
		
		List<Curso> lista = op10.lerTodos();
		for(Curso curso : lista) {
			System.out.println(curso);
		}
		*/
		
		/// TESTE: DELETAR CURSO
		/*
		IFuncoesCrud<Curso> op11 = new CursoDao();
		op11.deletar(2);
		*/
		
		/// TESTE: INSERIR DISCIPLINA
		/*
	    DisciplinaDtoRequisicao d1 = new DisciplinaDtoRequisicao(111, "Banco de Dados 1", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), null, "2M");
	    
	    DisciplinaDtoRequisicao d2 = new DisciplinaDtoRequisicao(222, "Arquitetura de Computadores", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), "1A2b3C4d5E6f7G", "2M");
	    
	    DisciplinaDtoRequisicao d3 = new DisciplinaDtoRequisicao(333, "Usinagem", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), "9z8y7x6w5v4u3t", "5k3j1h9");
	    
	    
	    IDisciplinaCrud op12 = new DisciplinaDao();
	    System.out.println(op12.inserir(d1));
	    System.out.println(op12.inserir(d2));
	    System.out.println(op12.inserir(d3));
	    */
		
		/// TESTE: ATUALIZAR DISCIPLINA
		/*
		DisciplinaDtoRequisicao d4 = new DisciplinaDtoRequisicao(111, "Banco de Dados 1", 
				LocalDate.of(2024, 7, 1), LocalDate.of(2024, 12, 1), null, "2M");
		
		IDisciplinaCrud op13 = new DisciplinaDao();
		System.out.println(op13.atualizar(888, d4));
		*/
		
		/// TESTE: LER DISCIPLINA
		/*
		IDisciplinaCrud op14 = new DisciplinaDao();
		System.out.println(op14.ler(111));
		*/
		
		/// TESTE: LER DISCIPLINAS
		/*
		IDisciplinaCrud op15 = new DisciplinaDao();
		for(DisciplinaDtoResposta dtoResposta : op15.lerTodos()) {
			System.out.println(dtoResposta);
		}
		*/
		
		/// TESTE: DELETAR DISCIPLINA
		/*
		IDisciplinaCrud op16 = new DisciplinaDao();
		op16.deletar(333);
		*/
		
	}

}
