package entities;

import java.time.LocalDate;

public class Disciplina {
    private Integer numero;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataEncerramento;

    public Disciplina() {
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

    public Boolean validarData(){
        if(dataInicio.isAfter(dataEncerramento))
        {
            return false;
        }
        return true;
    }
    
}
