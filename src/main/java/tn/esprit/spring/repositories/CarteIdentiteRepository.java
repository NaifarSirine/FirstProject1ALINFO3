package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.CarteIdentite;

public interface CarteIdentiteRepository extends JpaRepository<CarteIdentite,Long> {
}
