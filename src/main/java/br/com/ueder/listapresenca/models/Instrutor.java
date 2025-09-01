package br.com.ueder.listapresenca.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrutores")
public class Instrutor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;

    @ManyToOne(optional = false, targetEntity = Cargo.class, fetch = FetchType.EAGER)
    private Cargo cargo;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(length = 255)
    private String email;

    @Column(length = 20, nullable = false)
    private String documentoOficial;

    private Boolean ativo = true;

    @Column(length = 500)
    private String observacoes;

    public Instrutor() {

    }

    public Instrutor(String nome, Cargo cargo, String telefone, String email) {
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setDocumentoOficial(String documentoOficial) {
        this.documentoOficial = documentoOficial;
    }

    public String getDocumentoOficial() {
        return documentoOficial;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((documentoOficial == null) ? 0 : documentoOficial.hashCode());
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
        Instrutor other = (Instrutor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (documentoOficial == null) {
            if (other.documentoOficial != null)
                return false;
        } else if (!documentoOficial.equals(other.documentoOficial))
            return false;
        return true;
    }

}