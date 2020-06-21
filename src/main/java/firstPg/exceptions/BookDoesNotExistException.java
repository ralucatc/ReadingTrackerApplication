package firstPg.exceptions;

public class BookDoesNotExistException extends Exception{

    public BookDoesNotExistException (String title) {
        super(String.format("A book with this title %s doesn't exist!", title));
    }
}
