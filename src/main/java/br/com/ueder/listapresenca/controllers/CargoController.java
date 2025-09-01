package br.com.ueder.listapresenca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ueder.listapresenca.dtos.cargos.CargoList;
import br.com.ueder.listapresenca.services.CargoService;
import br.com.ueder.listapresenca.utils.Util;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/apis")
public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping("/cargos/v1")
    public ResponseEntity<List<CargoList>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/cargos/v1/{id}")
    public ResponseEntity<CargoList> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/cargos/v1")
    public ResponseEntity<CargoList> save(@RequestBody CargoList cargo) {
        var saveCargo = service.save(cargo);
        return ResponseEntity.created(Util.createUri(saveCargo.id(), "/apis/cargos/v1")).body(saveCargo);
    }

    @PutMapping("/cargos/v1/{id}")
    public ResponseEntity<CargoList> save(@PathVariable Long id, @RequestBody CargoList cargo) {
        service.findById(id);
        var saveCargo = service.save(cargo);
        return ResponseEntity.ok().body(saveCargo);
    }

    @DeleteMapping("/cargos/v1/{id}")
    public ResponseEntity<?> save(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Cargo deletado com sucesso!");
    }

}
