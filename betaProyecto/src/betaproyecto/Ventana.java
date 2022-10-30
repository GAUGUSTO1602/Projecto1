/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author veronica
 */
public class Ventana extends JPanel {
    private Laberinto laberinto;

    public Ventana(Laberinto lab){
        laberinto = lab;

    }

    @Override
    public void paint(Graphics grafico){
        laberinto.paint(grafico);
    }

    public void crearVentana(Ventana ven, Lista marco, Lista mLista){
        JFrame miVentana = new JFrame("Laberinto");
        miVentana.add(ven);
        miVentana.setSize(900, 750);
        miVentana.setLocationRelativeTo(null);
        miVentana.setVisible(true);
        Opciones venOpciones = new Opciones();
        venOpciones.setVisible(true);
        venOpciones.setLocation(750, 0);
        venOpciones.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    
}
