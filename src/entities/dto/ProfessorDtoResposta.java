package entities.dto;

import java.time.LocalDate;

public class ProfessorDtoResposta {
private String codigoFuncional;
    private String nome;
    private LocalDate dataNasc;
    
    public ProfessorDtoResposta(){}

    public ProfessorDtoResposta(String codigoFuncional, String nome, LocalDate dataNasc) {
        this.codigoFuncional = codigoFuncional;
        this.nome = nome;
        this.dataNasc = dataNasc;
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}
