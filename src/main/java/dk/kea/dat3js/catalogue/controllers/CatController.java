package dk.kea.dat3js.catalogue.controllers;

import dk.kea.dat3js.catalogue.entities.Cat;
import dk.kea.dat3js.catalogue.services.CatService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
    info = @Info(
        title = "The Catalogue application",
        version = "1.0",
        description = "A large catalogue of famous cats"
    )
)
@RestController
@RequestMapping("/cats")
public class CatController {

  private final CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

  @Operation(summary="Get all the cats",
             description = "Returns a list of all the cats in the catalogue")
  @GetMapping
  public List<Cat> getAllCats() {
    return catService.findAll();
  }

  @Operation(summary = "Get a single cat",
             description = "Returns a single cat from the catalogue, if one with the given id exists",
             responses = {
                @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                                       schema = @Schema(implementation = Cat.class)),
                    description = "A Cat"),
                @ApiResponse(responseCode = "404",
                    content = @Content,
                    description = "No cat found with given id")
      })
  @GetMapping("/{id}")
  public ResponseEntity<Cat> getCat(
      @Parameter(description = "Id of the cat to be returned.", required = true)
      @PathVariable int id) {
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
