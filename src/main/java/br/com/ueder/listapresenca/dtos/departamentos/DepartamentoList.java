package br.com.ueder.listapresenca.dtos.departamentos;

import br.com.ueder.listapresenca.models.Departamento;

public record DepartamentoList(Long id, String descricao, Boolean ativo) {

    public DepartamentoList(Departamento depto) {
        this(depto.getId(), depto.getDescricao(), depto.getAtivo());
    }

    public Departamento toModel() {
        var depto = new Departamento(descricao);
        depto.setAtivo(this.ativo);
        depto.setId(this.id);
        return depto;
    }

}
