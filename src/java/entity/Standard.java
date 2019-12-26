/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author SHERIF ABOUELMAGD
 */
public class Standard {
    
    private int id;
    private String code, description, title, category, domain;

    public Standard(int id, String code, String description, String title, String category, String domain) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.title = title;
        this.category = category;
        this.domain = domain;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getDomain() {
        return domain;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Standard{" + "id=" + id + ", code=" + code + ", description=" + description + ", title=" + title + ", category=" + category + ", domain=" + domain + '}';
    }
    
    
}
