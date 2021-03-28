package laberinto2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego extends JPanel {
    
    Laberinto laberinto = new Laberinto();
    Personaje personaje = new Personaje();
    
    public Juego() {
        addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
        
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics grafico) {
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }
    
    public boolean isEnd(){
        boolean isEnd = personaje.llego();
        return isEnd;
    }
    
    
    
    
    public static void main(String[] args) {
        Juego game = new Juego();
        Usuario usuario = new Usuario();
        
        
        usuario.askName();
        
        JFrame miventana = new JFrame("Laberinto");
        miventana.add(game);
        
        int ciclo = 0;
        
        miventana.setSize(936, 556);
        miventana.setLocation(300, 200);
        miventana.setVisible(true);
        miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(ciclo == 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            miventana.repaint();
            
            game.isEnd();
            
            if(game.isEnd() == true){
                break;
            }
        }
        
        usuario.end();
        
    }
}
