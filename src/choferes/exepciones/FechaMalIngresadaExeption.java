/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

import java.time.LocalDate;

/**
 *
 * Excepción que se lanza cuando se ingresa una fecha inválida.
 * La fecha no puede ser un año negativo.
 * 
 * @author manso
 */
public class FechaMalIngresadaExeption extends Exception{
    protected LocalDate fecha;

    /**
     * Construye una nueva excepción con la fecha especificada.
     * 
     * @param fecha La fecha que causó la excepción.
     */
    public FechaMalIngresadaExeption(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la fecha que causó la excepción.
     * 
     * @return La fecha que causó la excepción.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "el aÃ±o ingresado en negativo o cero";
    }
    
}
