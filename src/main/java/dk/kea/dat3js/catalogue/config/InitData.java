package dk.kea.dat3js.catalogue.config;

import dk.kea.dat3js.catalogue.entities.Cat;
import dk.kea.dat3js.catalogue.services.CatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
  private final CatService catService;

  public InitData(CatService catService) {
    this.catService = catService;
  }

  @Override
  public void run(String... args) throws Exception {
    createCats();
  }

  private void createCats() {
    List<Cat> cats = new ArrayList<>();
    cats.add(new Cat("Tuxedo Stan", "Canada", "ran for mayor of Halifax, Nova Scotia in 2012", 2010));
    cats.add(new Cat("Mittens", "New Zealand", "wandered in Te Aro, Wellington, and the city's central business district", 2009));
    cats.add(new Cat("Gacek", "Poland", "a prominent tourist attraction in the city of Szczecin, Poland", 2013));
    cats.add(new Cat("Tombili", "Turkey", " a street cat from Istanbul. He was internationally known because of a photograph that shows his reclining on the sidewalk.", null));
    cats.add(new Cat("Casper", "United Kingdom", "a cat who regularly rode the bus on his own in Plymouth and had a book written about his story.", 1997));
    cats.add(new Cat("Catmando", "United Kingdom", "joint leader of the Official Monster Raving Loony Party from 1999 to 2002",1995));
    cats.add(new Cat("Nala", "United Kingdom", "known for sitting at the ticket barriers in Stevenage railway station", 2019));

    catService.saveAll(cats);
  }
}
