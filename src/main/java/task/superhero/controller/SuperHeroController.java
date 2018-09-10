package task.superhero.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import task.superhero.model.CreationFeedBack;
import task.superhero.model.SuperHero;
import task.superhero.service.SuperHeroService;

@RestController
@RequestMapping("/api")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;

    @GetMapping("/superhero")
    public @ResponseBody List<SuperHero> getAllSuperHeros(){
        return superHeroService.getAllSuperHeros();
    }

    @GetMapping("/superhero/{id}")
    public ResponseEntity<Object> getSuperHero(@PathVariable Long id){
        Optional<SuperHero> superHero = superHeroService.findSuperHeroById(id);

        return superHero.isPresent() ? ResponseEntity.ok().body(superHero.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/superhero/add")
    public ResponseEntity<CreationFeedBack> addSuperHero(@Valid SuperHero newSuperHero, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            superHeroService.addSuperHero(newSuperHero);
            return ResponseEntity.ok(new CreationFeedBack(true,bindingResult.getAllErrors(),newSuperHero));
        }
        return ResponseEntity.badRequest().body(new CreationFeedBack(false, bindingResult.getAllErrors(),newSuperHero));

    }
}
