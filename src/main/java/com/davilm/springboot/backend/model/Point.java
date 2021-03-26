package com.davilm.springboot.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

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
}
