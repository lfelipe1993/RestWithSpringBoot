package br.net.digitalzone.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.digitalzone.data.vo.v1.BookVO;
import br.net.digitalzone.data.vo.v1.PersonVO;
import br.net.digitalzone.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Book EndPoint", description =  "Description for book", tags = {"Book EndPoint"})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private PagedResourcesAssembler<BookVO> assembler;

	@ApiOperation(value = "Find all books")
	@GetMapping(value = "/findBookByTitle/{title}",produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(@RequestParam(value = "page",defaultValue = "0") int page,
			@PathVariable("title") String title,
			@RequestParam(value = "limit",defaultValue = "15") int limit,
			@RequestParam(value = "direction",defaultValue = "asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit,Sort.by(sortDirection,"title"));

		Page<BookVO> books = service.findBookByTitle(title, pageable);

		books.stream()
				.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		
		PagedResources<?> resources = assembler.toResource(books);

		return new ResponseEntity<>(resources,HttpStatus.OK);
	}

	@ApiOperation(value = "Find Book by Id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BookVO findById(@PathVariable("id") Long id) {

		BookVO bookVO = service.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());

		return bookVO;

	}

	@ApiOperation(value = "Create a book")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO create(@RequestBody BookVO book) {

		BookVO bookVO = service.create(book);

		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());

		return bookVO;

	}

	@ApiOperation(value = "Update a book")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO update(@RequestBody BookVO book) {

		BookVO bookVO = service.update(book);

		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());

		return bookVO;

	}

	@ApiOperation(value = "Delete any book")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();

	}

}
