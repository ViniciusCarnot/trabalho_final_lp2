package entities.dto;

import java.time.LocalDate;

import exceptions.DataDisciplinaExcessao;
import exceptions.RecursoComValorNullExcessao;

public class DisciplinaDtoRequisicao {
	
	private Integer numero;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataEncerramento;
	private String codigoProfessor;
	private String codigoCurso;
	
	public DisciplinaDtoRequisicao() {
	}

	public DisciplinaDtoRequisicao(Integer numero, String nome, LocalDate dataInicio, LocalDate dataEncerramento,
			String codigoProfessor, String codigoCurso) {
		validarValoresNull(numero, nome, dataInicio, dataEncerramento, codigoCurso);
		this.numero = numero;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.codigoProfessor = codigoProfessor;
		this.codigoCurso = codigoCurso;
		validarData(dataInicio, dataEncerramento);
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

	public String getCodigoProfessor() {
		return codigoProfessor;
	}

	public void setCodigoProfessor(String codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	public void validarValoresNull(Integer numero, String nome, LocalDate dataInicio, LocalDate dataEncerramento,
			String codigoCurso) {
		if(numero == null) {
			throw new RecursoComValorNullExcessao("O campo 'Número' não pode ser null.");
		}
		if(nome == null) {
			throw new RecursoComValorNullExcessao("O campo 'Nome da Disciplina' não pode ser null.");
		}
		if(dataInicio == null) {
			throw new RecursoComValorNullExcessao("O campo 'Data Início' não pode ser null.");	
		}
		if(dataEncerramento == null) {
			throw new RecursoComValorNullExcessao("O campo 'Data Encerramento' não pode ser null.");
		}
		if(codigoCurso == null) {
			throw new RecursoComValorNullExcessao("O campo 'Curso' não pode ser null.");
		}
	}
	
	public void validarData(LocalDate dataInicio, LocalDate dataEncerramento){
        if(dataInicio.isAfter(dataEncerramento))
        {
            throw new DataDisciplinaExcessao("Erro: Data de início é anterior a data de encerramento.");
        }
    }
}
