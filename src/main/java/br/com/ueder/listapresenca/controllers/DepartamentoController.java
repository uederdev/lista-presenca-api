package br.com.ueder.listapresenca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ueder.listapresenca.dtos.departamentos.DepartamentoList;
import br.com.ueder.listapresenca.services.DepartamentoService;
import br.com.ueder.listapresenca.utils.Util;

@RestController
@RequestMapping("/apis")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/departamentos/v1")
    public ResponseEntity<List<DepartamentoList>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/departamentos/v1/{id}")
    public ResponseEntity<DepartamentoList> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/departamentos/v1/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Departamento deletado com sucesso!");
    }

    @PostMapping("/departamentos/v1")
    public ResponseEntity<DepartamentoList> save(@RequestBody DepartamentoList dto) {
        var depto = service.save(dto);
        return ResponseEntity.created(Util.createUri(depto.id(), "/departamentos/v1")).body(depto);
    }

    @PutMapping("/departamentos/v1/{id}")
    public ResponseEntity<DepartamentoList> update(@PathVariable Long id, @RequestBody DepartamentoList dto) {
        var depto = service.save(dto);
        return ResponseEntity.ok(depto);
    }

}
