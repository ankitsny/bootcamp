package input.PersonExercise.exception;

public class MalePersonCannotGiveBirthException extends Exception {

    public MalePersonCannotGiveBirthException() {
        super("Male person cannot give birth to a child.");
    }
}
