import kontroler.Kontroler;
import gui.Widok;
import procesor.Model;

/**
 * Klasa startowa inicjalizująca obiekty modelu mvc.
 *
 * @author grzegorzokon
 */
public class Start {
    public static void main (String[] args){
        Widok widok = new Widok();        
        Model model = new Model();

        Kontroler kontroler = new Kontroler(widok, model);
        widok.ustawReferencję(kontroler);
    }
}