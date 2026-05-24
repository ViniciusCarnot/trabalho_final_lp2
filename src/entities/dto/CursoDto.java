package entities.dto;

import java.time.LocalDate;

public class CursoDto {
	
	private Integer id;
	private String codigo;
	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataEncerramentoPrevista;
	
	public CursoDto() {
	}

	public CursoDto(Integer id, String codigo, String nome, String descricao, LocalDate dataInicio,
			LocalDate dataEncerramentoPrevista) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataEncerramentoPrevista = dataEncerramentoPrevista;
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

	@Override
	public String toString() {
		return "CursoDto [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao
				+ ", dataInicio=" + dataInicio + ", dataEncerramentoPrevista=" + dataEncerramentoPrevista + "]";
	}
	
}
