package entities;

import java.time.LocalDate;

public class Professor {
	
	private String codigoFuncional;
	private String nome;
	private LocalDate dataNascimento;
	
	public Professor() {
	}

	public Professor(String codigoFuncional, String nome, LocalDate dataNascimento) {
		this.codigoFuncional = codigoFuncional;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
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
	
}
