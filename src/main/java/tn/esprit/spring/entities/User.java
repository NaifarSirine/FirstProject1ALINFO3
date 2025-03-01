package tn.esprit.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity // C'est une entité JPA
@Table(name = "Utilisateur")// Pour définir le nom de la table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    @Transient
    int age;
    @OneToOne(mappedBy = "user")
    CarteIdentite carteIdentite;
}
