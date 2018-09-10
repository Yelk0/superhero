package task.superhero.controller;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import task.superhero.model.SuperHero;
import task.superhero.service.SuperHeroService;

@RunWith(SpringRunner.class)
@WebMvcTest(SuperHeroController.class)
public class SuperHeroControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SuperHeroService superHeroService;

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void whenSuperheroesEndpointHitThenListOfSuperHeroesShouldBeReturned() throws Exception {
        SuperHero superMan = new SuperHero();
        superMan.setName("Superman");
        SuperHero batman = new SuperHero();
        batman.setName("Batman");
        List<SuperHero> allSuperheroes = Arrays.asList(superMan, batman);

        given(superHeroService.getAllSuperHeros()).willReturn(allSuperheroes);

        mvc.perform(get("/api/superhero")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().string(containsString(superMan.getName())))
                .andExpect(content().string(containsString(batman.getName())));
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void whenEndpointHitWithValidIDThenSuperHeroShouldBeReturned() throws Exception {
        SuperHero superMan = new SuperHero();
        superMan.setName("Superman");

        given(superHeroService.findSuperHeroById(Long.valueOf(1))).willReturn(Optional.of(superMan));

        mvc.perform(get("/api/superhero/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(superMan.getName())));
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void whenEndpointHitWithNotValidIDThen404ShouldBeReturned() throws Exception {
        SuperHero superMan = new SuperHero();
        superMan.setName("Superman");

        given(superHeroService.findSuperHeroById(Long.valueOf(1))).willReturn(Optional.of(superMan));

        mvc.perform(get("/api/superhero/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
