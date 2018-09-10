package task.superhero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.superhero.model.SuperHero;
import task.superhero.repository.SuperHeroRepository;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Override
    public List<SuperHero> getAllSuperHeros() {
        return superHeroRepository.findAll();
    }

    @Override
    public Optional<SuperHero> findSuperHeroById(Long id) {
        return superHeroRepository.findById(id);
    }

    @Override
    public void addSuperHero(SuperHero superHero) {
        superHeroRepository.save(superHero);
    }
}
