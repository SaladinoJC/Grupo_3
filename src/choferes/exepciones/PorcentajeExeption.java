/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 *
 * @author manso
 */
public class PorcentajeExeption extends Exception{
    protected double porcentaje;

    public PorcentajeExeption(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    @Override
    public String toString() {
        return "el porcentaje debe ser un numemero mayot igual a 0";
    }
    
    
    
}
