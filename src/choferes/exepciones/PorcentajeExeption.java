/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 *
 * Excepci�n que se lanza cuando se ingresa un porcentaje inv�lido.
 * El porcentaje debe ser un numero mayor o igual a 0
 * 
 * @author manso
 */
public class PorcentajeExeption extends Exception{
    protected double porcentaje;

    /**
     * Construye una nueva excepci�n con el porcentaje especificado.
     * 
     * @param porcentaje El porcentaje que caus� la excepci�n.
     */
    public PorcentajeExeption(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * Obtiene el porcentaje que caus� la excepci�n.
     * 
     * @return El porcentaje que caus� la excepci�n.
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    @Override
    public String toString() {
        return "El porcentaje debe ser un numero mayor o igual a 0";
    }
    
    
}
