package procesor.wyjście;

import java.util.*;
import com.restfb.json.JsonValue;
import procesor.wejście.Facebook;
import procesor.wyjątki.NotFoundException;

/**
 *
 * @author Grzesiek
 */
public class UsługaFacebook implements FacebookService{
    private TreeSet<Facebook> profile;
    
    public UsługaFacebook(TreeSet<Facebook> profile) {
        this.profile = profile;
    }
    
    /**
     * Zwraca obiekt reprezentujący profil Facebooka na podstawie id
     * w czasie logarytmicznym
     */
    public Facebook findById(String id) throws NotFoundException {
        
        return null;
    }

    /**
     * Zwraca mapę której kluczem jest słowo a wartością liczba jego
     * wystąpień - pod uwagę brane są wszystkie posty 
     * 
     * @return Mapa przechowująca słowa i wystąpienia.     
     */
    public Map<String, Long> findMostCommonWords() {
        Map<String, Long> wyliczenie = new HashMap<>();
        for(Facebook profil : profile) {
            for (JsonValue post : profil.get("posts").asArray()) {
                String treść = post.asObject().get("message").asString();                
                String[] słowa = treść.trim().split("[\\,\\s\\!\\.\\;\\{\\(\\}\\)\\/\\-:\\?]");   //podział ciągu tekstowego na słowa po znakach specjalnych
                for (String słowo : słowa) {
                    if (!słowo.equals("")) {     //odrzucenie pustych ciągów znaków
                        if (wyliczenie.containsKey(słowo) == false ) {   
                            wyliczenie.put(słowo, 1l);
                        } else {
                            Long ilość = wyliczenie.get(słowo);
                            wyliczenie.remove(słowo);
                            wyliczenie.put(słowo, ilość + 1);
                        }                        
                    }
                }
            }
        }                 
        return wyliczenie;
    }

    /**
     * Zwraca zbiór id postów zawierających słowo word.
     * 
     * @param word
     *           Szukane słowo.
     * @return Kolekcja przechowująca treść postów.
     */
    public Set<String> findPostIdsByKeyword(String word) {
        Set<String> posty = new HashSet<>();        
        for(Facebook profil : profile) {
            for (JsonValue post : profil.get("posts").asArray()) {
                String treść = post.asObject().get("message").asString();                
                if (treść.contains(word)) {
                    posty.add(treść);
                }
            }
        }       
        return posty;
    }

    /**
     * Zwraca zbiór obiektów reprezentujących profile Facebooka
     * posortowane po firstname, lastname
     */
    public Set<Facebook> findAll() {
        
        return null;
    }
}
