package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import exceptions.DataDisciplinaExcessao;

public class Curso {
	
	private Integer id;
	private String codigo;
	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataEncerramentoPrevista;
	
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	public Curso() {
	}

	public Curso(Integer id, String codigo, String nome, String descricao, LocalDate dataInicio,
			LocalDate dataEncerramentoPrevista) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataEncerramentoPrevista = dataEncerramentoPrevista;
		validarData(dataInicio, dataEncerramentoPrevista);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataEncerramentoPrevista() {
		return dataEncerramentoPrevista;
	}

	public void setDataEncerramentoPrevista(LocalDate dataEncerramentoPrevista) {
		this.dataEncerramentoPrevista = dataEncerramentoPrevista;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void validarData(LocalDate dataInicio, LocalDate dataEncerramentoPrevista){
        if(dataInicio.isAfter(dataEncerramentoPrevista))
        {
            throw new DataDisciplinaExcessao("Erro: Data de início é anterior a data de encerramento.");
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(id, other.id);
	}

}
