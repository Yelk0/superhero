package task.superhero.model;

import java.util.List;

import org.springframework.validation.ObjectError;

public class CreationFeedBack {

    private boolean success;
    private List<ObjectError> errors;
    private SuperHero superHero;

    public CreationFeedBack(boolean success, List<ObjectError> errors, SuperHero superHero) {
        this.success = success;
        this.errors = errors;
        this.superHero = superHero;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public SuperHero getSuperHero() {
        return superHero;
    }

    public void setSuperHero(SuperHero superHero) {
        this.superHero = superHero;
    }
}
