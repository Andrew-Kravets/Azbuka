package com.andrewkravets.azbuka.library.model;

import com.andrewkravets.azbuka.library.model.AuthorObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:03
 */
public class LetterObject implements Serializable {
    private String title;
    private ArrayList<AuthorObject> authors;

    public LetterObject(String title, ArrayList<AuthorObject> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<AuthorObject> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<AuthorObject> authors) {
        this.authors = authors;
    }

    public int getAmount(){
        return authors.size();
    }
}
