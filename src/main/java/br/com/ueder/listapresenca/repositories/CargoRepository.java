package br.com.ueder.listapresenca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ueder.listapresenca.models.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
