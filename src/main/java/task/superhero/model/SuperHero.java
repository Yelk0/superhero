package task.superhero.model;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import task.superhero.enumerable.Publisher;
import task.superhero.enumerable.Skill;
import task.superhero.validation.NotEmptyFields;

@Entity
public class SuperHero {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "superhero_Sequence")
    @SequenceGenerator(name = "superhero_Sequence", sequenceName = "SUPERHERO_SEQ")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "You must provide a superhero name")
    private String name;

    @Column(name = "pseudonym")
    private String pseudonym;

    @Enumerated(EnumType.STRING)
    private Publisher publisher;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Skill> skills;

    @ElementCollection
    @NotEmptyFields
    private List<String> allies;

    @Column(name = "first_appearance")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "The first appearance cannot be a date in the future")
    private LocalDate firstAppearance;

    public SuperHero() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<String> getAllies() {
        return allies;
    }

    public void setAllies(List<String> allies) {
        this.allies = allies;
    }

    public LocalDate getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(LocalDate firstAppearance) {
        this.firstAppearance = firstAppearance;
    }
}