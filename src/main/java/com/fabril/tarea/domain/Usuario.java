package com.fabril.tarea.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String Name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dateOfBirth")
    private String date;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
}
