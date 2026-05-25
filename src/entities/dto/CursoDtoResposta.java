package entities.dto;

import java.time.LocalDate;

public class CursoDtoResposta {
	
	private String codigo;
	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataEncerramentoPrevista;
	
	public CursoDtoResposta() {
	}

	public CursoDtoResposta(String codigo, String nome, String descricao, LocalDate dataInicio, LocalDate dataEncerramentoPrevista) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataEncerramentoPrevista = dataEncerramentoPrevista;
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
		StringBuilder sb = new StringBuilder();
		sb.append("CURSO").append("\n");
		sb.append("Código: ").append(codigo).append("\n");
		sb.append("Nome: ").append(nome).append("\n");
		if(descricao == null) {
			sb.append("Descrição: ").append("").append("\n");
		} else {
			sb.append("Descrição: ").append(descricao).append("\n");
		}
		sb.append("Data de Ínicio: ").append(dataInicio).append("\n");
		sb.append("Data de Encerramento Prevista: ").append(dataEncerramentoPrevista).append("\n");
		return sb.toString();
	}
	
	

}
