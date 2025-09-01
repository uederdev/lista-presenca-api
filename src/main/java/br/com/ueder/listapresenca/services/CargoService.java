package br.com.ueder.listapresenca.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ueder.listapresenca.dtos.cargos.CargoList;
import br.com.ueder.listapresenca.exceptions.ObjectNotFoundException;
import br.com.ueder.listapresenca.repositories.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public CargoList findById(Long id) {
        return repository.findById(id).map(CargoList::new)
                .orElseThrow(() -> new ObjectNotFoundException("Cargo não encontrado: " + id));
    }

    public CargoList save(CargoList dto) {
        if (dto.id() != null) {
            var update = findById(dto.id()).toModel();
            update.setDescricao(dto.nome());
            update.setAtivo(dto.ativo());
            return new CargoList(repository.save(update));
        } else {
            return new CargoList(repository.save(dto.toModel()));
        }
    }

    public void delete(Long id) {
        var cargo = findById(id);
        repository.delete(cargo.toModel());
    }

    public List<CargoList> findAll() {
        var lista = repository.findAll().stream().map(CargoList::new).collect(Collectors.toList());
        if (lista.isEmpty()) {
            throw new ObjectNotFoundException("Nenhum cargo cadastrado...");
        }
        return lista;
    }

}
