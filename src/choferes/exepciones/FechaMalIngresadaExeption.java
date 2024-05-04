/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

import java.time.LocalDate;

/**
 *
 * Excepci�n que se lanza cuando se ingresa una fecha inv�lida.
 * La fecha no puede ser un a�o negativo.
 * 
 * @author manso
 */
public class FechaMalIngresadaExeption extends Exception{
    protected LocalDate fecha;

    /**
     * Construye una nueva excepci�n con la fecha especificada.
     * 
     * @param fecha La fecha que caus� la excepci�n.
     */
    public FechaMalIngresadaExeption(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la fecha que caus� la excepci�n.
     * 
     * @return La fecha que caus� la excepci�n.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "el año ingresado en negativo o cero";
    }
    
}
