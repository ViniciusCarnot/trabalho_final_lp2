package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Professor {
	
	private Integer id;
	private String codigoFuncional;
	private String nome;
	private LocalDate dataNascimento;
	
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	public Professor() {
	}

	public Professor(Integer id, String codigoFuncional, String nome, LocalDate dataNascimento) {
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

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoFuncional, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(codigoFuncional, other.codigoFuncional) && Objects.equals(id, other.id);
	}

	

}
