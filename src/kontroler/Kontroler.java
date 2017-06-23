package kontroler;

import gui.Widok;
import gui.komunikaty.*;
import java.util.Map;
import java.util.Set;
import procesor.Model;
import procesor.wejście.Źródło;
import static procesor.wejście.Źródło.*;

/**
 *
 * @author Grzesiek
 */
public class Kontroler {
    private Widok widok;   
    private Model model;
    
    public Kontroler(Widok view, Model model){
        this.widok = view;
        this.model = model;
    }

    /*
     * Metoda wykonująca działanie zależnie od przesłanego obiektu komunikatu. Wykorzystano wzorzec strategia.
     * 
     * @param komunikat
     *          Przekazany komunikat        
     */   
    public void wykonajAkcję(Komunikat komunikat) {        
        if (komunikat instanceof WyszukajPoIDKomunikat) {            
            
        } else if (komunikat instanceof WyszukajWystąpieniaSłówKomunikat) {
            Map<String, Long> wyliczenie = model.findMostCommonWords();
            for (Map.Entry<String, Long> encja : wyliczenie.entrySet()) {
                widok.dodajKomunikat("Słowo: " + encja.getKey() + ", wystąpienia: " + encja.getValue());
            }
        } else if (komunikat instanceof WyszukajPoSłowieKomunikat) {   
            Set<String> posty = model.findPostIdsByKeyword((((WyszukajPoSłowieKomunikat)komunikat).pobierzSzukaneSłowo()));
            for (String post : posty) {
                widok.dodajKomunikat(post);
            }
        }
    }
}
