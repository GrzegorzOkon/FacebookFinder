package procesor.wyjście;

import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import procesor.wejście.Facebook;
import procesor.wyjątki.NotFoundException;

/**
 *
 * @author grzegorzokon
 */
public class UsługaFacebookTest {
    UsługaFacebook usługa;
    TreeSet<Facebook> profile;
    Facebook profilPierwszy;
    Facebook profilDrugi;
    Map<String, Long> wystąpienia;    
    
    public UsługaFacebookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        profile = new TreeSet<>();
        profilPierwszy = new Facebook();
        profilPierwszy.add("id", "1");
        profilPierwszy.add("firstname", "Kuna");
        profilPierwszy.add("lastname", "Matata");        
        profilPierwszy.add("posts", new JsonArray().add(new JsonObject().add("id", "31").add("message", "Owned it two months and still haven't used all the features! The pictures is absolutely amazing! All the Smart TV services are overwhelming! Spectacular center piece for our new living room!"))
                                       .add(new JsonObject().add("id", "32").add("message", "was created to help with debugging. As JSON data is often output without line breaks to save space, it is extremely difficult to actually read and make sense of it. This little tool hoped to solve the problem by formatting the JSON data so that it is easy"))
                                       .add(new JsonObject().add("id", "33").add("message", "Testowy post.")));        
        profilDrugi = new Facebook();
        profilDrugi.add("id", "2");  
        profilDrugi.add("firstname", "Adam"); 
        profilDrugi.add("lastname", "Janus"); 
        profilDrugi.add("posts", new JsonArray().add(new JsonObject().add("id", "41").add("message", "My husband wanted to buy the Samsung... Samsung,, Samsung! Samsung? 4K curve tv against my preference (we are traditionally a SONY family) but I must say that it is quite exceptional and the picture is undeniably real. I can safely say after one month, I am spoiled and know I will have difficulty watching anything else!"))
                                       .add(new JsonObject().add("id", "42").add("message", "Owned it two months and still haven't used all the features! The pictures is absolutely amazing! All the Smart TV services are overwhelming! Spectacular center piece for our new living room!"))
                                       .add(new JsonObject().add("id", "43").add("message", "I like this curve even I'm sitting on the side and I can still see it as if I'm in front of my tv. Hope they lower the price so I can by for my loft")));   
        profile.add(profilPierwszy);
        profile.add(profilDrugi);
        usługa = new UsługaFacebook(profile);
    }
    
    @After
    public void tearDown() {
        usługa = null;
        profilPierwszy = null;
        profilDrugi = null;  
        wystąpienia = null;
    }

    /**
     * Test metody FindById w klasie UsługaFacebook.
     * Prosty test sprawdzający najprostszy przypadek.
     */
    @Test
    public void testFindByIdSimple() throws Exception {
        assertEquals("Kuna", (usługa.findById("1")).get("firstname").asString());
        assertEquals("Adam", (usługa.findById("2")).get("firstname").asString());
    }

    /**
     * Test metody FindById w klasie UsługaFacebook.
     * Test sprawdzający obsługę wartości null.
     */
    @Test
    public void testFindByIdNull() throws Exception {
        assertNull(usługa.findById(null));
    }    

    /**
     * Test metody FindById w klasie UsługaFacebook.
     * Test sprawdzający wygenerowanie wyjątku w przypadku braku identyfikatora.
     */
    @Test
    public void testFindByIdException() throws Exception {
        try {
            usługa.findById("kol");
            fail();
        } catch (NotFoundException ex) {
            assertTrue(true);
        }
    }
    
    /**
     * Test metody testFindMostCommonWords w klasie UsługaFacebook.
     * Prosty test sprawdzający najprostszy przypadek.
     */
    @Test
    public void testFindMostCommonWordsSimple() {
        Map<String, Long> wystąpienia = usługa.findMostCommonWords();        
        assertEquals(new Long(2), wystąpienia.get("spectacular")); 
    }

    /**
     * Test metody testFindMostCommonWords w klasie UsługaFacebook.
     * Test sprawdzający usuwanie znaków specjalnych.
     */
    @Test
    public void testFindMostCommonWordsSpecialSigns() {
        Map<String, Long> wystąpienia = usługa.findMostCommonWords();        
        assertEquals(new Long(4), wystąpienia.get("samsung")); 
    }    

    /**
     * Test metody testFindMostCommonWords w klasie UsługaFacebook.
     * Test sprawdzający zliczanie słów niezależnie od wielkości liter.
     */
    @Test
    public void testFindMostCommonWordsCharacterSize() {
        Map<String, Long> wystąpienia = usługa.findMostCommonWords();        
        assertEquals(new Long(4), wystąpienia.get("samsung")); 
    }
    
    /**   
     * Test metody testFindMostCommonWords w klasie UsługaFacebook.
     * Test sprawdzający najprostszy przypadek.
     */
    @Test
    public void testFindPostIdsByKeywordSimple() {
        assertEquals(1, usługa.findPostIdsByKeyword("Testowy").size());
    }

    /**   
     * Test metody testFindMostCommonWords w klasie UsługaFacebook.
     * Test sprawdzający obsługę wartości null.
     */
    @Test
    public void testFindPostIdsByKeywordNull() {
        assertNull(usługa.findPostIdsByKeyword(null));
    }     
    
    /**   
     * Test metody testFindMostCommonWords w klasie UsługaFacebook.
     * Test sprawdzający czy posty są wybierane niezależnie od wielkości liter.
     */
    @Test
    public void testFindPostIdsByKeywordCharacterSize() {
        assertEquals(1, usługa.findPostIdsByKeyword("TESTOWY").size());
    }    
    
    /**
     * Test metody testFindAllSimple w klasie UsługaFacebook.
     * Test sprawdzający najprostszy przypadek.
     */
    @Test
    public void testFindAllSimple() {
        Set<Facebook> posortowaneProfile = usługa.findAll();
        for (Facebook profil : posortowaneProfile) {
            assertEquals("Adam", profil.get("firstname").asString());
            break;
        }        
    }
}
