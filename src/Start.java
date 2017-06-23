/**
 *
 * @author Grzesiek
 */

import kontroler.Kontroler;
import gui.Widok;
import procesor.Model;

/**
 *  Klasa uruchomieniowa. Łączy ze sobą poszcególne klasy modelu mvc.
 * 
 */
public class Start {
    public static void main (String[] args){
        Widok widok = new Widok();        
        Model model = new Model();

        Kontroler kontroler = new Kontroler(widok, model);
        widok.ustawReferencję(kontroler);
    }
}