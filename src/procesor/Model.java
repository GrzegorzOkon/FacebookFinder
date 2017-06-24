package procesor;

import java.util.*;
import procesor.wejście.*;
import procesor.wyjątki.NotFoundException;
import procesor.wyjście.*;

/**
 * Klasa modelu w architekturze mvc. Lączy dane i uruchamia działania.
 * 
 * @author grzegorzokon
 */
public class Model {
    /**
     * Obiekt prechowujący załadowane profile Facebook.
     */
    TreeSet<Facebook> profile = new Źródło().pobierzProfile();
    
    /**
     * Obiekt służący do uruchamiania działań na przekazanych danych profilowych.
     */
    UsługaFacebook usługa = new UsługaFacebook(profile);

    /**
     * Zwraca obiekt reprezentujący profil Facebooka na podstawie id
     * w czasie logarytmicznym
     * 
     * @param id
     *           Szukany identyfikator.
     * @return Profil facebookowy.
     * @exception NotFoundException
     *           Jeżeli metoda nie znajduje przesłanego numeru ID.
     */
    public Facebook findById(String id) throws NotFoundException {
        return usługa.findById(id);
    }

    /**
     * Zwraca mapę której kluczem jest słowo a wartością liczba jego
     * wystąpień - pod uwagę brane są wszystkie posty 
     * 
     * @return Mapa przechowująca słowa i wystąpienia.     
     */    
    public Map<String, Long> findMostCommonWords() {
        return usługa.findMostCommonWords();
    }

    /**
     * Zwraca zbiór id postów zawierających słowo word.
     * 
     * @param word
     *           Szukane słowo.
     * @return Kolekcja przechowująca treść postów.
     */    
    public Set<String> findPostIdsByKeyword(String word) {
        return usługa.findPostIdsByKeyword(word);
    }
 
    /**
     * Zwraca zbiór obiektów reprezentujących profile Facebooka
     * posortowane po firstname, lastname
     * 
     * @return Kolekcja obiektów reprezentujących profile Facebooka posortowanych po firstname, lastname.
     */    
    public Set<Facebook> findAll() {
        return usługa.findAll();
    }
}
