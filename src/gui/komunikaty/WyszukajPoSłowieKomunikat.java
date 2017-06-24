package gui.komunikaty;

/**
 * Klasa służąca do presłania komunikatu o potrzebie wyszukania po słowie.
 * 
 * @author grzegorzokon
 */
public class WyszukajPoSłowieKomunikat extends Komunikat {
    private final String szukaneSłowo;
    
    public WyszukajPoSłowieKomunikat(String tekst) {
        szukaneSłowo = tekst;
    }
    
    public String pobierzSzukaneSłowo() {
        return szukaneSłowo;
    }
}
