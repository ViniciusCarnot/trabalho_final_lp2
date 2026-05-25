package application;

public class Program {

	public static void main(String[] args) {
		
		/// TESTE: INSERIR PROFESSOR
		/*
		ProfessorDtoRequisicao p1 = new ProfessorDtoRequisicao("PCP111", "Guilherme Seyos", LocalDate.of(1980, 1, 1));
		
		IProfessorCrud op1 = new ProfessorDao();
		System.out.println(op1.inserir(p1));
		*/ 

		/// TESTE: ATUALIZAR PROFESSOR
		/*
		ProfessorDtoRequisicao p2 = new ProfessorDtoRequisicao("PCP777", "Guilherme Pintos", LocalDate.of(1980, 1, 1));
		
		IProfessorCrud op2 = new ProfessorDao();
		System.out.println(op2.atualizar("PCP222", p2));
		*/

		/// TESTE: LER PROFESSOR
		/*
		IProfessorCrud op3 = new ProfessorDao();
		System.out.println(op3.ler("PCP777"));
		*/

		/// TESTE: LER PROFESSORES
		/*
		IProfessorCrud op4 = new ProfessorDao();

		List<ProfessorDtoResposta> lista = op4.lerTodos();
		for(ProfessorDtoResposta dto : lista) {
			System.out.println(dto);
		}
		*/

		/// TESTE: DELETAR PROFESSOR
		/*
		IProfessorCrud op6 = new ProfessorDao();
		op6.deletar("PCP111"); 
		*/
		
		/// TESTE: INSERIR CURSO
		/*
		CursoDtoRequisicao c1 = new CursoDtoRequisicao("ENGCOMP", "Engenharia da Computação", null, LocalDate.of(2024,  2, 1), 
				LocalDate.of(2027, 12, 1));
		
		CursoDtoRequisicao c2 = new CursoDtoRequisicao("ENGMEC", "Engenharia Mecânica", 
				"Curso destinado a montagem e manutenção de peças.", LocalDate.of(2024,  2, 1), 
				LocalDate.of(2027, 12, 1));
				
		ICursoCrud op7 = new CursoDao();
		System.out.println(op7.inserir(c1));
		System.out.println(op7.inserir(c2));
		*/
		
		/// TESTE: ATUALIZAR CURSO
		/*
		CursoDtoRequisicao c3 = new CursoDtoRequisicao("ENGELET", "Engenharia Elétrica", 
				"Curso destinado a montagem e manutenção de circuitos elétricos.", LocalDate.of(2025,  2, 1), 
				LocalDate.of(2028, 12, 1));
		
		ICursoCrud op8 = new CursoDao();
		System.out.println(op8.atualizar("ENGELET", c3));
		*/
		
		/// TESTE: LER CURSO
		/*
		ICursoCrud op9 = new CursoDao();
		System.out.println(op9.ler("ENGCOMP"));
		System.out.println(op9.ler("ENGELET"));
		*/
		
		/// TESTE: LER CURSOS
		/*
		ICursoCrud op10 = new CursoDao();
		
		List<CursoDtoResposta> lista = op10.lerTodos();
		for(CursoDtoResposta dtoResposta : lista) {
			System.out.println(dtoResposta);
		}
		*/
		
		/// TESTE: DELETAR CURSO
		/*
		ICursoCrud op11 = new CursoDao();
		op11.deletar("engmec");
		*/
		
		/// TESTE: INSERIR DISCIPLINA
		/*
	    DisciplinaDtoRequisicao d1 = new DisciplinaDtoRequisicao(111, "Banco de Dados 1", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), null, "ENGCOMP");
	    
	    DisciplinaDtoRequisicao d2 = new DisciplinaDtoRequisicao(222, "Arquitetura de Computadores", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), "1A2b3C4d5E6f7G", "ENGCOMP");
	    
	    DisciplinaDtoRequisicao d3 = new DisciplinaDtoRequisicao(333, "Usinagem", 
				LocalDate.of(2025, 7, 1), LocalDate.of(2025, 12, 1), "7H2j9K4m1P8q3N", "ENGELET");
	    
	    
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
