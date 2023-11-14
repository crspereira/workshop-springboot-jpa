package com.claytonpereira.springproject01.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descriotion;
    private Double price;
    private String umgURL;

    @Transient //Anotation para o JPA ignorar a relação
    private Set<Category> categories = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String descriotion, Double price, String umgURL) {
        this.id = id;
        this.name = name;
        this.descriotion = descriotion;
        this.price = price;
        this.umgURL = umgURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUmgURL() {
        return umgURL;
    }

    public void setUmgURL(String umgURL) {
        this.umgURL = umgURL;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descriotion='" + descriotion + '\'' +
                ", price=" + price +
                ", umgURL='" + umgURL + '\'' +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
