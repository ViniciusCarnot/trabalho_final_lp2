package application;

import java.time.LocalDate;
import java.util.List;

import entities.dao.*;
import entities.dto.*;
import entities.interfaces.*;

public class Program {

	public static void main(String[] args) {
		
		/// TESTE: INSERIR PROFESSOR
		/*
		ProfessorDtoRequisicao p1 = new ProfessorDtoRequisicao("PCP111", "Guilherme Seiya", LocalDate.of(1980, 1, 1));
		
		IProfessorCrud op1 = new ProfessorDao();
		System.out.println(op1.inserir(p1));
		*/

		/// TESTE: ATUALIZAR PROFESSOR
		/*
		ProfessorDtoRequisicao p2 = new ProfessorDtoRequisicao("PCP222", "Guilherme Hashizumi", LocalDate.of(2006, 3, 9));
		
		IProfessorCrud op2 = new ProfessorDao();
		System.out.println(op2.atualizar("PCP111", p2));
		*/

		/// TESTE: LER PROFESSOR
		/*
		IProfessorCrud op3 = new ProfessorDao();
		System.out.println(op3.ler("PCP222"));
		*/

		/// TESTE: LER PROFESSORES
		/*
		ProfessorDtoRequisicao p3 = new ProfessorDtoRequisicao("PCP333", "Vinicius Carnot", LocalDate.of(2006, 10, 31));
		IProfessorCrud op4 = new ProfessorDao();
		op4.inserir(p3);

		ProfessorDtoRequisicao p4 = new ProfessorDtoRequisicao("PCP444", "Victor Hirai", LocalDate.of(2006, 2, 14));
		IProfessorCrud op5 = new ProfessorDao();
		op5.inserir(p4);
		
		IProfessorCrud op6 = new ProfessorDao();

		List<ProfessorDtoResposta> lista = op6.lerTodos();
		for(ProfessorDtoResposta dto : lista) {
			System.out.println(dto);
		}
		*/

		/// TESTE: DELETAR PROFESSOR
		/*
		IProfessorCrud op7 = new ProfessorDao();
		op7.deletar("PCP444"); 
		*/
		
		/// TESTE: INSERIR CURSO
		/*
		CursoDtoRequisicao c1 = new CursoDtoRequisicao("ENGCOMP", "Engenharia da Computação", null, LocalDate.of(2024,  2, 1), 
				LocalDate.of(2027, 12, 1));
		
		CursoDtoRequisicao c2 = new CursoDtoRequisicao("ENGMEC", "Engenharia Mecânica", 
				"Curso destinado a montagem e manutenção de peças.", LocalDate.of(2024,  2, 1), 
				LocalDate.of(2027, 12, 1));
				
		ICursoCrud op8 = new CursoDao();
		System.out.println(op8.inserir(c1));
		System.out.println(op8.inserir(c2));
		*/
		
		/// TESTE: ATUALIZAR CURSO
		/*
		CursoDtoRequisicao c3 = new CursoDtoRequisicao("ENGELET", "Engenharia Elétrica", 
				"Curso destinado a montagem e manutenção de circuitos elétricos.", LocalDate.of(2025,  2, 1), 
				LocalDate.of(2028, 12, 1));
		
		ICursoCrud op9 = new CursoDao();
		System.out.println(op9.atualizar("ENGMEC", c3));
		*/
		
		/// TESTE: LER CURSO
		/*
		ICursoCrud op10 = new CursoDao();
		System.out.println(op10.ler("ENGCOMP"));
		System.out.println(op10.ler("ENGELET"));
		*/
		
		/// TESTE: LER CURSOS
		/*
		ICursoCrud op11 = new CursoDao();
		
		List<CursoDtoResposta> lista = op11.lerTodos();
		for(CursoDtoResposta dtoResposta : lista) {
			System.out.println(dtoResposta);
		}
		*/
		
		/// TESTE: DELETAR CURSO
		/*
		ICursoCrud op12 = new CursoDao();
		op12.deletar("ENGELET");
		*/
		
		/// TESTE: INSERIR DISCIPLINA
		/*
	    DisciplinaDtoRequisicao d1 = new DisciplinaDtoRequisicao(111, "Banco de Dados 1", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), null, "ENGCOMP");
	    
	    DisciplinaDtoRequisicao d2 = new DisciplinaDtoRequisicao(222, "Arquitetura de Computadores", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), "PCP222", "ENGCOMP");
	    
	    DisciplinaDtoRequisicao d3 = new DisciplinaDtoRequisicao(333, "Usinagem", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), "PCP333", "ENGMEC");
	    
	    
	    IDisciplinaCrud op13 = new DisciplinaDao();
	    System.out.println(op13.inserir(d1));
	    System.out.println(op13.inserir(d2));
	    System.out.println(op13.inserir(d3));
		*/
	    
		
		/// TESTE: ATUALIZAR DISCIPLINA
		/*
		DisciplinaDtoRequisicao d4 = new DisciplinaDtoRequisicao(111, "Banco de Dados 1", 
				LocalDate.of(2024, 7, 1), LocalDate.of(2024, 12, 1), null, "ENGCOMP");
		
		IDisciplinaCrud op14 = new DisciplinaDao();
		System.out.println(op14.atualizar(111, d4));
		*/
		
		/// TESTE: LER DISCIPLINA
		/*
		IDisciplinaCrud op15 = new DisciplinaDao();
		System.out.println(op15.ler(111));
		*/
		
		/// TESTE: LER DISCIPLINAS
		/*
		IDisciplinaCrud op16 = new DisciplinaDao();
		for(DisciplinaDtoResposta dtoResposta : op16.lerTodos()) {
			System.out.println(dtoResposta);
		}
		*/
		
		/// TESTE: DELETAR DISCIPLINA
		/*
		IDisciplinaCrud op17 = new DisciplinaDao();
		op17.deletar(111);
		*/
		
	}

}
