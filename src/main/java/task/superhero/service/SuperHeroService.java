package task.superhero.service;

import java.util.List;
import java.util.Optional;

import task.superhero.model.SuperHero;

public interface SuperHeroService {
    List<SuperHero> getAllSuperHeros();
    Optional<SuperHero> findSuperHeroById(Long id);
    void addSuperHero(SuperHero superHero);
}
