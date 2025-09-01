package br.com.ueder.listapresenca.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ueder.listapresenca.dtos.departamentos.DepartamentoList;
import br.com.ueder.listapresenca.exceptions.ObjectNotFoundException;
import br.com.ueder.listapresenca.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public DepartamentoList findById(Long id) {
        return repository.findById(id).map(DepartamentoList::new)
                .orElseThrow(() -> new ObjectNotFoundException("Departamento não encontrado: " + id));
    }

    public void delete(Long id) {
        var depto = findById(id);
        repository.delete(depto.toModel());
    }

    public List<DepartamentoList> findAll() {
        var lista = repository.findAll().stream()
                .map(DepartamentoList::new).collect(Collectors.toList());
        if (lista.isEmpty()) {
            throw new ObjectNotFoundException("Nenhum departamento cadastrado...");
        }
        return lista;
    }

    public DepartamentoList save(DepartamentoList dto) {
        if (dto.id() != null) {
            var update = findById(dto.id()).toModel();
            update.setAtivo(dto.ativo());
            update.setId(dto.id());
            update.setDescricao(dto.descricao());
            return new DepartamentoList(repository.save(update));
        } else {
            return new DepartamentoList(repository.save(dto.toModel()));
        }
    }

}
