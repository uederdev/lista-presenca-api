package br.com.ueder.listapresenca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ueder.listapresenca.models.Instrutor;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

}
