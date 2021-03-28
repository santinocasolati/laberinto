package laberinto2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Personaje {

    Laberinto lab = new Laberinto();

    private int x = 40;
    private int y = 40;
    private final int ancho = 40;
    private final int alto = 40;
    private final int movimiento = 40;
    int[][] laberinto = lab.obtieneLaberinto();

    public void paint(Graphics grafico) {
        
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);
        grafico.setColor(Color.red);
        grafico.fillOval(x, y, ancho, alto);
    }
    

    public void teclaPresionada(KeyEvent evento) {

        if (evento.getKeyCode() == 37) { //Izquierda
            if (laberinto[y / 40][(x / 40) - 1] != 1) {
                x = x - movimiento;
            }
        }

        if (evento.getKeyCode() == 39) { //Derecha
            if (laberinto[y / 40][(x / 40) + 1] != 1) {
                x = x + movimiento;
            }
        }

        if (evento.getKeyCode() == 40) { //Abajo
            if (laberinto[(y / 40) + 1][x / 40] != 1) {
                y = y + movimiento;
            }
        }

        if (evento.getKeyCode() == 38) { //Arriba
            if (laberinto[(y / 40) - 1][x / 40] != 1) {
                y = y - movimiento;
            }
        }

    }

    public boolean llego() {

        boolean end = false;

        if (laberinto[y / 40][x / 40] == 2) {
            end = true;
        }

        return end;
    }


}
