package task.superhero.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyFieldsValidator implements ConstraintValidator<NotEmptyFields, List<String>> {

    @Override
    public void initialize(NotEmptyFields notEmptyFields) {
    }

    @Override
    public boolean isValid(List<String> strings, ConstraintValidatorContext context) {
        return strings==null || strings.stream().allMatch(str -> str != null && !str.trim().isEmpty());
    }

}