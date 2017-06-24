package procesor.wyjątki;

/**
 * Klasa wyjątku wykorzystanego do pokazania braku szukanego profilu.
 * 
 * @author grzegorzokon
 */
public class NotFoundException extends Exception {
    /**
     * Konstruktor bezargumentowy.
     */
    public NotFoundException() {
        super();
    }

    /**
     * Konstruktor z opisem błędu.
     */    
    public NotFoundException(String message) {
        super(message);
    }    
}
