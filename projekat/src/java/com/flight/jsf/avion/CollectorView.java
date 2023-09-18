package com.flight.jsf.avion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CollectorView implements Serializable {
    
    private String code;
    private Book book;
    private List<Book> books;
    

    @PostConstruct
    public void init() {
        book = new Book();
        books = new ArrayList<Book>();

    }

    
    

    public void createNew() {
        if (books.contains(book)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            books.add(book);
            book = new Book();
        }
    }

    public String reinit() {
        book = new Book();

        return null;
    }

    public Book getBook() {
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }

    
    
    //mislim da mi ova metoda uopste nece trebati
    public void action(){
	   code = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("hidden1");
	}
}
