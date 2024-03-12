package dk.kea.dat3js.catalogue.repositories;

import dk.kea.dat3js.catalogue.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat,Integer> {
}
