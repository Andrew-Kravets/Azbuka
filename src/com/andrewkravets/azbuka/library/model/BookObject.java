package com.andrewkravets.azbuka.library.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:03
 */
public class BookObject implements Serializable {
    private String title;
    private String url;
    private String txtUrl;

    public BookObject(String title, String url, String txtUrl) {
        this.title = title;
        this.url = url;
        this.txtUrl = txtUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(String txtUrl) {
        this.txtUrl = txtUrl;
    }
}
