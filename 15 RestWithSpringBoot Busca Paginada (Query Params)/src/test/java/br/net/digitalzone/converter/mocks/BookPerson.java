package br.net.digitalzone.converter.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.net.digitalzone.data.model.Book;
import br.net.digitalzone.data.vo.v1.BookVO;

public class BookPerson {


    public Book mockEntity() {
    	return mockEntity(0,0.00);
    }
    
    public BookVO mockVO() {
    	return mockVO(0,0.00);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
        	double ii = i;
            books.add(mockEntity(i,ii));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
        	double ii = i;
            books.add(mockVO(i,ii));
        }
        return books;
    }
    
    private Book mockEntity(Integer number, Double doubleNumber) {
    	Book book = new Book();
    	book.setAuthor("Author Name Test" + number);
    	book.setLaunch_date(new Date());
    	book.setPrice(doubleNumber);
    	book.setTitle("Title Test" + number);
        book.setId(number.longValue());
    	
    	
        return book;
    }

    private BookVO mockVO(Integer number, Double doubleNumber) {
    	BookVO book = new BookVO();
    	book.setAuthor("Author Name Test" + number);
    	book.setLaunch_date(new Date());
    	book.setPrice(doubleNumber);
    	book.setTitle("Title Test" + number);
        book.setKey(number.longValue());
        
        return book;
    }

}
