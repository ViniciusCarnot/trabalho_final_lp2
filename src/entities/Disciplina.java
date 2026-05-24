package entities;

import java.time.LocalDate;
import java.util.Objects;

import exceptions.DataDisciplinaExcessao;

public class Disciplina {
	
	private Integer id;
    private Integer numero;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataEncerramento;
    
    private Curso curso;
    
    private Professor professor;
    
    public Disciplina() {
    }
    
    public Disciplina(Integer id, Integer numero, String nome, LocalDate dataInicio, LocalDate dataEncerramento, Curso curso) {
    	this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.curso = curso;
		validarData(dataInicio, dataEncerramento);
	}

	public Disciplina(Integer id, Integer numero, String nome, LocalDate dataInicio, LocalDate dataEncerramento,
			 Curso curso, Professor professor) {
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.curso = curso;
		this.professor = professor;
		validarData(dataInicio, dataEncerramento);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
    
    public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

    public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void validarData(LocalDate dataInicio, LocalDate dataEncerramento){
        if(dataInicio.isAfter(dataEncerramento))
        {
            throw new DataDisciplinaExcessao("Erro: Data de início é anterior a data de encerramento.");
        }
    }
	
	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", numero=" + numero + ", nome=" + nome + ", dataInicio=" + dataInicio
				+ ", dataEncerramento=" + dataEncerramento + ", curso=" + curso + ", professor=" + professor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}

}
