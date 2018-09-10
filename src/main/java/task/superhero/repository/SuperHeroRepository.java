package task.superhero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.superhero.model.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

}