package task.superhero.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import task.superhero.model.SuperHero;
import task.superhero.repository.SuperHeroRepository;

@RunWith(SpringRunner.class)
public class SuperHeroServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public SuperHeroService superHeroService() {
            return new SuperHeroServiceImpl();
        }
    }

    @Autowired
    private SuperHeroService superHeroService;

    @MockBean
    private SuperHeroRepository superHeroRepository;

    @Before
    public void setUp() {
        SuperHero superMan = new SuperHero();
        superMan.setName("Superman");
        Long id = Long.valueOf(1);
        Mockito.when(superHeroRepository.findById(id)).thenReturn(Optional.of(superMan));
    }

    @Test
    public void whenValidIdthenSuperheroShouldBeFound() {
        String name = "Superman";
        SuperHero superHero = superHeroService.findSuperHeroById(Long.valueOf(1)).get();
        assertEquals(superHero.getName(), name);
    }

    @Test
    public void whenNotValidIdthenSuperheroShouldBeFound() {
        assertFalse(superHeroService.findSuperHeroById(Long.valueOf(2)).isPresent());
    }
}
