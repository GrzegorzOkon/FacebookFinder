package gui;

import gui.komunikaty.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import kontroler.Kontroler;

/**
 *
 * @author Grzesiek
 */
public class Widok extends JFrame {
    private Kontroler kontroler;
    private JFrame ramka;  
    private JMenuBar pasekMenu;  
    private JMenu file;   
    private JMenuItem quitMenuItem;  
    private JMenu helpMenu;  
    private JMenuItem aboutMenuItem; 
    private JPanel głównyPanel;  
    private JPanel panelGórny;
    private JPanel panelDolny;
    private JButton buttonLoad;
    private JButton findByID;
    private JButton findByWords; 
    private JPanel panelWyszukajPoSłowie;  
    private JPanel podpanelWyszukajPoSłowie;
    private JTextArea poleWyszukajPoSłowie;
    private JButton findByWord;    
    private JButton sortProfiles; 
    private JScrollPane panelKonsoli;
    private JTextArea konsola;    
    
    //Konstruktor klasy inicjalizuje obiekty na pierwszym okienku.
    public Widok() {
        ramka = new JFrame("Facebook Finder");
        pasekMenu = new JMenuBar(); 
        file = new JMenu();
        quitMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem(); 
        głównyPanel = new JPanel(); 
        panelGórny = new JPanel();
        panelDolny = new JPanel();
        buttonLoad = new JButton();
        findByID = new JButton(); 
        findByWords = new JButton(); 
        panelWyszukajPoSłowie = new JPanel();
        podpanelWyszukajPoSłowie = new JPanel();
        poleWyszukajPoSłowie = new JTextArea();
        findByWord = new JButton();
        sortProfiles = new JButton();
        panelKonsoli = new JScrollPane();
        konsola = new JTextArea(); 
        
        //Generuje wygląd okienka
        ramka.setUndecorated(true);
        ramka.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
        ramka.setResizable(false);
               
        //Utworzenie menu i podmenu
        ramka.setJMenuBar(pasekMenu);
        
        file.setMnemonic('f');
        file.setText("Plik");        
        pasekMenu.add(file);
        
        quitMenuItem.setMnemonic('x');
        quitMenuItem.setText("Zamknij");
        quitMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0); 
            }
        });        
        file.add(quitMenuItem);
        
        helpMenu.setMnemonic('h');
        helpMenu.setText("Pomoc");        
        pasekMenu.add(helpMenu);
        
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("O programie...");
        aboutMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(aboutMenuItem, 
                        "Facebook Finder v.1.0\nAutor: Grzegorz Okoń\nProjekt na rekrutację",
                        "O programie\u2026",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });        
        helpMenu.add(aboutMenuItem);        
        
        głównyPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 5));
        panelGórny.setLayout(new java.awt.GridLayout(0, 2, 5, 5));
        
        findByID.setText("Wyszukaj po ID");
        findByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontroler.wykonajAkcję(new WyszukajPoIDKomunikat());
            }
        });
        panelGórny.add(findByID);
 
        findByWords.setText("Wyszukaj wystąpienia słów");
        findByWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyczyść();
                kontroler.wykonajAkcję(new WyszukajWystąpieniaSłówKomunikat());
            }
        });
        panelGórny.add(findByWords);        

        panelWyszukajPoSłowie.setLayout(new BorderLayout());
        podpanelWyszukajPoSłowie.setLayout(new BorderLayout());
        podpanelWyszukajPoSłowie.add(poleWyszukajPoSłowie, BorderLayout.CENTER);
        podpanelWyszukajPoSłowie.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelWyszukajPoSłowie.add(podpanelWyszukajPoSłowie, BorderLayout.NORTH);
                
        panelWyszukajPoSłowie.add(findByWord, BorderLayout.CENTER);
        findByWord.setText("Wyszukaj po słowie");
        findByWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyczyść();
                if (!poleWyszukajPoSłowie.getText().trim().equals(""))
                    kontroler.wykonajAkcję(new WyszukajPoSłowieKomunikat(poleWyszukajPoSłowie.getText()));
            }
        });
        panelGórny.add(panelWyszukajPoSłowie);

        sortProfiles.setText("Sortuj profile");
        /*findByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontroler.wykonajAkcję(new PrzeglądajNiezalogowanyKomunikat());
            }
        });*/
        panelGórny.add(sortProfiles);
        głównyPanel.add(panelGórny);        
        
        konsola.setEditable(false);
        konsola.setColumns(20);
        konsola.setRows(5);
        konsola.setWrapStyleWord(true);
        panelKonsoli.setViewportView(konsola);

        głównyPanel.add(panelKonsoli, java.awt.BorderLayout.CENTER);         
        głównyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //Fragment odpowiadający za rozmieszczenie elementów grafiznych według menedzera rozkładu BorderLayout
        ramka.getContentPane().setLayout(new BorderLayout());
        ramka.getContentPane().add(głównyPanel, BorderLayout.CENTER);        

        //Określenie rozmiaru okenka oraz jego wyświetlenie
        ramka.setSize(500,600);
        ramka.setLocationRelativeTo(null);   //Ustawienie na środku ekranu
        ramka.setVisible(true);
    }

    /**
     * Metoda wyswietlająca przesłany komunikat
     * @param komunikat treść przesłanego komunikatu
     */    
    public void dodajKomunikat(String komunikat) {
        konsola.append(komunikat + "\n"); // do interfejsu graficznego
    }

    /**
     * Metoda czyszcząca konsolę
     * 
     */    
    public void wyczyść() {
        konsola.setText(""); // do interfejsu graficznego
    }
    
    /**
     * Metoda przypisująca referencję do obiektu kontrolera
     * @param kontroler obiekt do którego ma być referencja
     */    
    public void ustawReferencję(Kontroler kontroler){
        this.kontroler = kontroler;
    }     
}
