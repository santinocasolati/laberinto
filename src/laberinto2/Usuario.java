
package laberinto2;

import javax.swing.JOptionPane;

public class Usuario {
    
    public String jugador;
    
    public void askName() {
        jugador = JOptionPane.showInputDialog("Hola. Bienvenido al laberinto. ¿Cual es tu nombre?:");
    }

    public void end() {
        JOptionPane.showMessageDialog(null, "Felicidades " + jugador + ". Ha completado el laberinto");
        System.exit(0);
    }
    
}
