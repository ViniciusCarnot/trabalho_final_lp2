package entities.dto;

import java.time.LocalDate;

import exceptions.DataCursoExcessao;
import exceptions.RecursoComValorNullExcessao;

public class CursoDtoRequisicao {
	
	private String codigo;
	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataEncerramentoPrevista;
	
	public CursoDtoRequisicao() {
	}

	public CursoDtoRequisicao(String codigo, String nome, String descricao, LocalDate dataInicio, LocalDate dataEncerramentoPrevista) {
		validarValoresNull(codigo, nome, dataInicio, dataEncerramentoPrevista);
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataEncerramentoPrevista = dataEncerramentoPrevista;
		validarData(dataInicio, dataEncerramentoPrevista);
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
	
	public void validarValoresNull(String codigo, String nome, LocalDate dataInicio, LocalDate dataEncerramentoPrevista) {
		if(codigo == null) {
			throw new RecursoComValorNullExcessao("O campo 'Código' não pode ser null.");
		}
		if(nome == null) {
			throw new RecursoComValorNullExcessao("O campo 'Nome do Curso' não pode ser null.");
		}
		if(dataInicio == null) {
			throw new RecursoComValorNullExcessao("O campo 'Data Início' não pode ser null.");	
		}
		if(dataEncerramentoPrevista == null) {
			throw new RecursoComValorNullExcessao("O campo 'Data Encerramento Prevista' não pode ser null.");
		}
	}
	
	public void validarData(LocalDate dataInicio, LocalDate dataEncerramento){
        if(dataInicio.isAfter(dataEncerramento))
        {
            throw new DataCursoExcessao("Erro: Data de início é anterior a data de encerramento.");
        }
    }
	
}
