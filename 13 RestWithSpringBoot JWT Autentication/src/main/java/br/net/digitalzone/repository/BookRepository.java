package br.net.digitalzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.digitalzone.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
