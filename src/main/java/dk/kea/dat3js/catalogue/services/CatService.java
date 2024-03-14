package dk.kea.dat3js.catalogue.services;

import dk.kea.dat3js.catalogue.entities.Cat;
import dk.kea.dat3js.catalogue.repositories.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {

  private final CatRepository catRepository;

  public CatService(CatRepository catRepository) {
    this.catRepository = catRepository;
  }

  public List<Cat> findAll() {
    return catRepository.findAll();
  }


  public Optional<Cat> findById(int id) {
    return catRepository.findById(id);
  }


  public Cat save(Cat cat) {
    return catRepository.save(cat);
  }

  public List<Cat> saveAll(List<Cat> cats) {
    return catRepository.saveAll(cats);
  }

  /**
   * Updates a <code>Cat</code> in the database, but only if one with the given id exists.
   *
   * @param id the id of the <code>Cat</code> object to update
   * @param cat a similar <code>Cat</code> object whose properties are used to update the database
   * @return an Optional containing the updated <code>Cat</code>, or empty if no <code>Cat</code> with that id was found
   */
  public Optional<Cat> updateIfExists(int id, Cat cat) {
    if (catRepository.existsById(id)) {
      cat.setId(id);
      return Optional.of(catRepository.save(cat));
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cat> partialUpdate(int id, Cat catUpdates) {
    Optional<Cat> optionalCat = catRepository.findById(id);
    if (optionalCat.isPresent()) {
      Cat originalCat = optionalCat.get();
      // update originalCat with properties in catUpdates
      if (catUpdates.getName() != null) originalCat.setName(catUpdates.getName());
      if (catUpdates.getCountry() != null) originalCat.setCountry(catUpdates.getCountry());
      if (catUpdates.getClaim_to_fame() != null) originalCat.setClaim_to_fame((catUpdates.getClaim_to_fame()));
      if (catUpdates.getBirthyear() != null) originalCat.setBirthyear(catUpdates.getBirthyear());
      return Optional.of(catRepository.save(originalCat));
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cat> deleteById(int id) {
    Optional<Cat> cat = catRepository.findById(id);
    catRepository.deleteById(id);
    return cat;
  }
}
