package gui.komunikaty;

/**
 *
 * @author Grzesiek
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
