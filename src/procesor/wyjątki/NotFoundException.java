package procesor.wyjątki;

/**
 *
 * @author Grzesiek
 */
public class NotFoundException extends Exception {
    public NotFoundException() {
        super();
    }
    
    public NotFoundException(String message) {
        super(message);
    }    
}
