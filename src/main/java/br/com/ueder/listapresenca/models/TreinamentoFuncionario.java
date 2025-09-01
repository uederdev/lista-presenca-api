package br.com.ueder.listapresenca.models;

import java.io.Serializable;

import br.com.ueder.listapresenca.models.enums.StatusFuncionarioCurso;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "treinamento_funcionarios")
public class TreinamentoFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, targetEntity = Treinamento.class)
    private Treinamento treinamento;

    @ManyToOne(optional = false, targetEntity = Funcionario.class)
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    private StatusFuncionarioCurso status;

    public TreinamentoFuncionario() {
    }

    public TreinamentoFuncionario(Treinamento treinamento, Funcionario funcionario) {
        this.treinamento = treinamento;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public StatusFuncionarioCurso getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(StatusFuncionarioCurso status) {
        this.status = status;
    }

}
