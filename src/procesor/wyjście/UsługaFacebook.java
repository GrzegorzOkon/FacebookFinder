package procesor.wyjście;

import java.util.*;
import com.restfb.json.JsonValue;
import procesor.wejście.Facebook;
import procesor.wyjątki.NotFoundException;

/**
 * Klasa implementująca interfejs FacebookService do działan na profilach.
 * 
 * @author grzegorzokon
 */
public class UsługaFacebook implements FacebookService{
    /**
     * Służy do przechowywania profili posortowanych domyślnie po id.
     */
    private TreeSet<Facebook> profile;
    
    /**
     * Konstruktor do tworzenia usługi Facebooka
     * 
     * @param profile
     *           Przekazane profile na których będą wykonywane metody.
     */   
    public UsługaFacebook(TreeSet<Facebook> profile) {
        this.profile = profile;
    }
    
    /**
     * Zwraca obiekt reprezentujący profil Facebooka na podstawie id
     * w czasie logarytmicznym
     * 
     * @param id
     *           Szukany identyfikator.
     * @return Profil facebookowy.
     * @throws NotFoundException
     *           Jeżeli metoda nie znajduje przesłanego numeru ID.
     */
    public Facebook findById(String id) throws NotFoundException {        
        for(Facebook profil : profile) {
            if (profil.get("id").asString().equals(id)) {
                return profil;
            } 
        }
        throw new NotFoundException("Nie znaleziono szukanego profilu");
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
                            wyliczenie.put(słowo, 1l);   //jeśli słowo nie występuje w mapie to nadaje wartość 1
                        } else {
                            Long ilość = wyliczenie.get(słowo);
                            wyliczenie.remove(słowo);
                            wyliczenie.put(słowo, ilość + 1);  //jeśli słowo już występuje to inkrementuje wartość w mapie o 1 
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
     * 
     * @return Kolekcja obiektów reprezentujących profile Facebooka posortowanych po firstname, lastname.
     */
    public Set<Facebook> findAll() {
        /**
         * Zbiór do przechowywania profili posortowanych przy użyciu komparatora
         */
        Set<Facebook> posortowaneProfile = new TreeSet<>(new Facebook());  
        
        for (Facebook profil : profile) {
            posortowaneProfile.add(profil);
        }       
        return posortowaneProfile;
    }
}
