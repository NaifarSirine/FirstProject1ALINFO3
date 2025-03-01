package tn.esprit.spring.entities;

import jakarta.persistence.*;

@Entity
public class CarteIdentite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, length = 8)
    Long cin;
    @OneToOne
    User user;

}
