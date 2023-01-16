package com.fabril.tarea.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "name",length = 30)
    private String Name;

    @Column(name = "lastname",length = 30)
    private String lastName;

    @Column(name = "dateOfBirth")
    private Date date;

    @Column(name = "phone",length = 25)
    private String phone;

    @Column(name = "address",length = 250)
    private String address;
}
