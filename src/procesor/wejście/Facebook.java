package procesor.wejście;

import com.restfb.json.JsonObject;
import java.util.*;

/**
 * Klasa rozszerzająca klasę JsonObject. Posiada zaimplementowane dwie metody sortujące.
 * 
 * @author grzegorzokon
 */
public class Facebook extends JsonObject implements Comparable<Facebook>, Comparator<Facebook> {
    /**
     * Nadpisana metoda interfejsu Comparable.
     * Umożliwia przechowywanie danych w TreeSet posortowanych po id.
     * 
     * @param face
     *           Obiekt profilu, który ma być porównany z bieżącym.
     * @return Wartość liczbowa porównania.
     */
    public int compareTo(Facebook face) {
        return this.get("id").asString().compareTo(face.get("id").asString());
    }
    
    /**
     * Nadpisana metoda interfejsu Comparator. 
     * Umożliwia porównywanie po firsname, lastname.
     * 
     * @param profil1
     *           Pierwszy profil do porównania.
     * @param profil2
     *           Drugi profil do porównania.
     * @return Wartość liczbowa porównania.
     */
    public int compare(Facebook profil1, Facebook profil2) {
       if (!profil1.get("firstname").asString().equals(profil2.get("firstname").asString())) {
            return profil1.get("firstname").asString().compareTo(profil2.get("firstname").asString());
       } else {
            return profil1.get("lastname").asString().compareTo(profil2.get("lastname").asString());
       }
   }
}
