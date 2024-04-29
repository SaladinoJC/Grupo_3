/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

import java.time.LocalDate;

/**
 *
 * @author manso
 */
public class FechaMalIngresadaExeption extends Exception{
    protected LocalDate fecha;

    public FechaMalIngresadaExeption(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "el año ingresado en negativo o cero";
    }
    
}
