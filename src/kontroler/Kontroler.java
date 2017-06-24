package kontroler;

import gui.Widok;
import gui.komunikaty.*;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import procesor.Model;
import procesor.wejście.Facebook;
import procesor.wejście.Źródło;
import static procesor.wejście.Źródło.*;
import procesor.wyjątki.NotFoundException;

/**
 * Klasa kontrolera w architekturze mvc. Pobiera komunikaty z widoku i wykonuje metody z modelu.
 * 
 * @author grzegorzokon
 */
public class Kontroler {
    private Widok widok;   
    private Model model;
    
    /**
     * Konstruktor klasy przypisujący referencje do obiektów.
     * 
     * @param widok
     *           Referencja do widoku.
     * @param model 
     *           Referencja do modelu.
     */    
    public Kontroler(Widok widok, Model model){
        this.widok = widok;
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
            try {
                Facebook profil = model.findById(((WyszukajPoIDKomunikat)komunikat).pobierzSzukaneID());
                widok.dodajKomunikat("id :" + profil.get("id").asString());
                widok.dodajKomunikat("imię: " + profil.get("firstname").asString());
                widok.dodajKomunikat("nazwisko: " + profil.get("lastname").asString());
                widok.dodajKomunikat("...");
            } catch (NotFoundException ex) {
                JOptionPane.showMessageDialog(widok, "Brak podanego numeru ID", "Komunikat\u2026", JOptionPane.INFORMATION_MESSAGE);
            } 
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
        } else if (komunikat instanceof WyszukajPosortowaneProfileKomunikat) {
            Set<Facebook> posortowaneProfile = model.findAll();
            
            for (Facebook profil : posortowaneProfile) {
                widok.dodajKomunikat("imię: " + profil.get("firstname").asString());
                widok.dodajKomunikat("nazwisko: " + profil.get("lastname").asString());
                widok.dodajKomunikat("_____________________");
            }
        }
    }
}
