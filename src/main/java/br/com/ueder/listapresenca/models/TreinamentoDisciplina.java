package br.com.ueder.listapresenca.models;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class TreinamentoDisciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, targetEntity = Treinamento.class)
    private Treinamento treinamento;

    @ManyToOne(optional = false, targetEntity = Disciplina.class)
    private Disciplina disciplina;

    private Integer cargaHoraria;

    public TreinamentoDisciplina() {
    }

    public TreinamentoDisciplina(Treinamento treinamento, Disciplina disciplina) {
        this.treinamento = treinamento;
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((treinamento == null) ? 0 : treinamento.hashCode());
        result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TreinamentoDisciplina other = (TreinamentoDisciplina) obj;
        if (treinamento == null) {
            if (other.treinamento != null)
                return false;
        } else if (!treinamento.equals(other.treinamento))
            return false;
        if (disciplina == null) {
            if (other.disciplina != null)
                return false;
        } else if (!disciplina.equals(other.disciplina))
            return false;
        return true;
    }

}
