package br.com.ueder.listapresenca.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ueder.listapresenca.models.enums.StatusTreinamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "treinamentos")
public class Treinamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String descricao;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @ManyToOne(optional = false, targetEntity = Instrutor.class)
    private Instrutor instrutor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataTermino;

    @Enumerated(EnumType.STRING)
    private StatusTreinamento status = StatusTreinamento.EM_CURSO;

    private String observacoes;

    private Set<TreinamentoFuncionario> funcionarios = new HashSet<>();

    private Set<TreinamentoDisciplina> disciplinas = new HashSet<>();

    public Treinamento() {
    }

    public Treinamento(String descricao, Integer cargaHoraria, LocalDate dataInicio) {
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.dataInicio = dataInicio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setStatus(StatusTreinamento status) {
        this.status = status;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Set<TreinamentoFuncionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(new TreinamentoFuncionario(this, funcionario));
    }

    public Set<TreinamentoDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(new TreinamentoDisciplina(this, disciplina));
    }

}
