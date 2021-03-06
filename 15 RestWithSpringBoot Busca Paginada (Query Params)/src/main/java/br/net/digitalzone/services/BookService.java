package br.net.digitalzone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.net.digitalzone.converter.DozerConverter;
import br.net.digitalzone.data.model.Book;
import br.net.digitalzone.data.vo.v1.BookVO;
import br.net.digitalzone.exception.ResourceNotFoundException;
import br.net.digitalzone.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		
		return vo;
	}
	
	public BookVO update(BookVO book) {
		
		var entity = repository.findById(book.getKey()).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunch_date(book.getLaunch_date());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		return DozerConverter.parseObject(repository.save(entity), BookVO.class);
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
	public BookVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public Page<BookVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToBookVO);
	}
	
	public Page<BookVO> findBookByTitle(String title, Pageable pageable) {
		var page = repository.findBookByTitle(title,pageable);
		return page.map(this::convertToBookVO);
	}
	
	public BookVO convertToBookVO(Book entity) {
		return DozerConverter.parseObject(entity, BookVO.class);
	}

}
