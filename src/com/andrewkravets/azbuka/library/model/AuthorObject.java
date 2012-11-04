package com.andrewkravets.azbuka.library.model;

import com.andrewkravets.azbuka.library.model.BookObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:03
 */
public class AuthorObject implements Serializable {
    private String name;
    private ArrayList<BookObject> books;

    public AuthorObject(String name, ArrayList<BookObject> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BookObject> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<BookObject> books) {
        this.books = books;
    }

    public int getAmount(){
        return books.size();
    }
}
