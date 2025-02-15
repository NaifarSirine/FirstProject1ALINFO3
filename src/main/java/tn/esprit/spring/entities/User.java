package tn.esprit.spring.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // C'est une entité JPA
@Table(name = "Utilisateur") // Pour définir le nom de la table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nom")
    String firstName;
    @Column(name = "prenom")
    String lastName;
    LocalDate birthday;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Column(unique = true, length = 8)
    Long cin;
    @Transient
    int age;
}
