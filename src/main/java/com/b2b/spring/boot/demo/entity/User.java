package com.b2b.spring.boot.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Utente")
public class User {
    //sezione attributi

    @Id
    @Column(name="IDUser")
    @SequenceGenerator(name="SEQCHIAVEUSER", sequenceName="SEQCHIAVEUSER", allocationSize = 1)
    @GeneratedValue(generator = "SEQCHIAVEUSER", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nome")
    private String nome;

    @Column(name="Email")
    private String email;

    @Column(name="Dettaglio")
    private String dettaglio;

}
