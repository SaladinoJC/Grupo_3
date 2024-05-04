/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 * Excepción que se lanza cuando se ingresa un sueldo invalido.
 * El sueldo debe ser un numero mayor o igual a 0
 * 
 * @author manso
 */
public class SueldoBasicoIncorrectoExeption extends Exception{
    protected  double  sueldoBasico;
    
    /**
     * Construye una nueva excepción con el sueldo especificado.
     * 
     * @param sueldoBasico El sueldo que causó la excepción.
     */
    public SueldoBasicoIncorrectoExeption(double sueldoBasico) {
        this.sueldoBasico=sueldoBasico;
    }

    /**
     * Obtiene el sueldo que causó la excepción.
     * 
     * @return El sueldo que causó la excepción.
     */
    public double getSueldoBasico() {
        return sueldoBasico;
    }

    @Override
    public String toString() {
        return "El sueldo basico debe ser un valor mayor o igual a 0";
    }
    
}
