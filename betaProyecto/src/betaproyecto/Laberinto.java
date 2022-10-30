/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author veronica
 */
public class Laberinto {
    private Integer fila = 0;
    private Integer columna = 0;
    private Integer numFilas;
    private Integer numColumnas;
    private Integer anchoBloque = 40;
    private Integer largoBloque = 40;
    private Integer[][] matriz;

    public Laberinto(Integer columnas, Integer filas, Integer[][] x){
        numFilas = filas;
        numColumnas = columnas;
        matriz = x;
    }

    public void paint(Graphics grafico){
       Integer[][] x = matriz;
        for (fila = 0; fila < numFilas; fila++) {
            for (columna = 0; columna  < numColumnas; columna++) {
                if(x[fila][columna] == 0 || x[fila][columna] == 2 || x[fila][columna] == 3){
                    grafico.setColor(Color.black);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, largoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, largoBloque);
                } else if(x[fila][columna] == 4){
                    grafico.setColor(Color.blue);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, largoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, largoBloque);
                }else if(x[fila][columna] == 5){
                    grafico.setColor(Color.red);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, largoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, largoBloque);
                }else if(x[fila][columna] == 6){
                    grafico.setColor(Color.green);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, largoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, largoBloque);
                }else{
                    grafico.setColor(Color.white);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, largoBloque);
                    grafico.setColor(Color.black);
                    grafico.drawRect(columna*40, fila*40, anchoBloque, largoBloque);
                }
            }
            
        }
    }

}
