package gui.komunikaty;

/**
 * Klasa służąca do presłania komunikatu o potrzebie wyszukania po ID.
 * 
 * @author grzegorzokon
 */
public class WyszukajPoIDKomunikat extends Komunikat {
    private final String szukaneID;
    
    public WyszukajPoIDKomunikat(String id) {
        szukaneID = id;
    }
    
    public String pobierzSzukaneID() {
        return szukaneID;
    }    
}
