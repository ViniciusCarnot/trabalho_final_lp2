package entities.dto;

import java.time.LocalDate;

public class ProfessorDto {
	
	private Integer id;
	private String codigoFuncional;
	private String nome;
	private LocalDate dataNascimento;
	
	public ProfessorDto() {
	}

	public ProfessorDto(Integer id, String codigoFuncional, String nome, LocalDate dataNascimento) {
		this.id = id;
		this.codigoFuncional = codigoFuncional;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoFuncional() {
		return codigoFuncional;
	}

	public void setCodigoFuncional(String codigoFuncional) {
		this.codigoFuncional = codigoFuncional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "ProfessorDto [id=" + id + ", codigoFuncional=" + codigoFuncional + ", nome=" + nome
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
}
