package dk.kea.dat3js.catalogue.controllers;

import dk.kea.dat3js.catalogue.entities.Cat;
import dk.kea.dat3js.catalogue.services.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

  private final CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

  @GetMapping
  public List<Cat> getAllCats() {
    return catService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cat> getCat(@PathVariable int id) {
    return ResponseEntity.of(catService.findById(id));
  }

  @PostMapping
  public Cat createCat(@RequestBody Cat cat) {
    return catService.save(cat);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cat> updateCat(@PathVariable int id, @RequestBody Cat cat) {
    return ResponseEntity.of(catService.updateIfExists(id, cat));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Cat> partialUpdateCat(@PathVariable int id, @RequestBody Cat cat) {
    return ResponseEntity.of(catService.partialUpdate(id, cat));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Cat> deleteCat(@PathVariable int id) {
    return ResponseEntity.of(catService.deleteById(id));
  }
}
