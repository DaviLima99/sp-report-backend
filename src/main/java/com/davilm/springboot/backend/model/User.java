package com.davilm.springboot.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    @Column(name = "email")
    @NotEmpty(message = "Email é obrigatório")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Digite uma senha")
    private String password;


    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Point> points = new ArrayList<>();

    public User() {}

    public User(@NotEmpty(message = "Nome é obrigatório") String name,
                @NotEmpty(message = "Email é obrigatório") String email,
                @NotEmpty(message = "Digite uma senha") String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
