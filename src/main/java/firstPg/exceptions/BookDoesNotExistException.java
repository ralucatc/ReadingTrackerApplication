package firstPg.exceptions;

public class BookDoesNotExistException extends Exception{
    private String title;

    public BookDoesNotExistException (String title) {

        super(String.format("A book with this title %s doesn't exist!", title));
        this.title = title;
    }
}
