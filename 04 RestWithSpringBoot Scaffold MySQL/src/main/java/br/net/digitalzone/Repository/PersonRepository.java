package br.net.digitalzone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.digitalzone.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
