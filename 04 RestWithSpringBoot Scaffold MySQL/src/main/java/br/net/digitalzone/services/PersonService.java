package br.net.digitalzone.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.net.digitalzone.model.Person;

@Service
public class PersonService {
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person(counter.incrementAndGet(),"Luiz","Mecina","Gerson Zanini, 453", "male");
		
		return person ;
	}
	
	public List<Person> findAll() {
		
		List<Person> persons = new ArrayList<Person>();
		
		for(int i =0; i < 8;i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person(counter.incrementAndGet(),"Luiz","Mecina " + i,"Gerson Zanini, 453", "male");
		return person;
	}

}
