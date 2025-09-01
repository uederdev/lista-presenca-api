package br.com.ueder.listapresenca.dtos.cargos;

import br.com.ueder.listapresenca.models.Cargo;

public record CargoList(Long id, String nome, Boolean ativo) {

    public CargoList(Cargo cargo) {
        this(cargo.getId(), cargo.getDescricao(), cargo.getAtivo());
    }

    public Cargo toModel() {
        var cargo = new Cargo(this.nome());
        cargo.setAtivo(this.ativo);
        cargo.setId(this.id);
        return cargo;
    }

}
