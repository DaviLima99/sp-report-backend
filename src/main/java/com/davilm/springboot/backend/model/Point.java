package com.davilm.springboot.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "points")
public class Point implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    @NotNull(message = "Título é obrigatório!")
    private String title;

    @Column(name="description")
    @NotNull(message = "Descrição é obrigatória!")
    private String description;

    @Column(name="image")
    @NotNull(message = "Imagem é obrigatória!")
    private String image;

    @Column(name="latitude")
    private double latitude;

    @Column(name = "longitude")
    private double  longitude;

    @Column(name="open")
    private Boolean open;

    public Point() {}

    public Point(String title, String description, String image, double latitude, double longitude, Boolean open) {
        super();
        this.title = title;
        this.description = description;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
        this.open = open;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
