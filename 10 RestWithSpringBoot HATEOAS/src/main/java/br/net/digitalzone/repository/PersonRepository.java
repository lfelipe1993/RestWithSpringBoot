package br.net.digitalzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.digitalzone.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
