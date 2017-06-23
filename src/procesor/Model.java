package procesor;

import java.util.*;
import procesor.wejście.*;
import procesor.wyjście.*;

/**
 *
 * @author Grzesiek
 */
public class Model {
    TreeSet<Facebook> profile = new Źródło().pobierzProfile();
    UsługaFacebook usługa = new UsługaFacebook(profile);
    
    public Map<String, Long> findMostCommonWords() {
        return usługa.findMostCommonWords();
    }
    
    public Set<String> findPostIdsByKeyword(String word) {
        return usługa.findPostIdsByKeyword(word);
    }
}
