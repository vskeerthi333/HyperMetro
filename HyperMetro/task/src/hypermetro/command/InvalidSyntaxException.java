package hypermetro.command;

public class InvalidSyntaxException extends RuntimeException {
    public InvalidSyntaxException(String msg) {
        super(msg);
    }
}
