package entities.dto;

import java.time.LocalDate;

public class DisciplinaDtoResposta {
	
	private Integer numero;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataEncerramento;
	private String codigoCurso;
	private String nomeCurso;
	private String codigoProfessor;
	private String nomeProfessor;
	
	public DisciplinaDtoResposta() {
	}

	public DisciplinaDtoResposta(Integer numero, String nome, LocalDate dataInicio, LocalDate dataEncerramento,
			String codigoCurso, String nomeCurso, String codigoProfessor, String nomeProfessor) {
		this.numero = numero;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.codigoCurso = codigoCurso;
		this.nomeCurso = nomeCurso;
		this.codigoProfessor = codigoProfessor;
		this.nomeProfessor = nomeProfessor;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getCodigoProfessor() {
		return codigoProfessor;
	}

	public void setCodigoProfessor(String codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DISCIPLINA").append("\n");
		sb.append("Número: ").append(numero).append("\n");
		sb.append("Nome: ").append(nome).append("\n");
		sb.append("Data de Ínicio: ").append(dataInicio).append("\n");
		sb.append("Data de Encerramento: ").append(dataEncerramento).append("\n");
		if(codigoProfessor == null) {
			codigoProfessor = "";
		}
		if(nomeProfessor == null) {
			nomeProfessor = "";
		}
		sb.append("Código do Professor: ").append(codigoProfessor).append("\n");
		sb.append("Nome do Professor: ").append(nomeProfessor).append("\n");
		sb.append("Código do Curso: ").append(codigoCurso).append("\n");
		sb.append("Nome do Curso: ").append(nomeCurso).append("\n");
		return sb.toString();
	}

}
