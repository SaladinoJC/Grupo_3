/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 * Excepci�n que se lanza cuando se ingresa un sueldo invalido.
 * El sueldo debe ser un numero mayor o igual a 0
 * 
 * @author manso
 */
public class SueldoBasicoIncorrectoExeption extends Exception{
    protected  double  sueldoBasico;
    
    /**
     * Construye una nueva excepci�n con el sueldo especificado.
     * 
     * @param sueldoBasico El sueldo que caus� la excepci�n.
     */
    public SueldoBasicoIncorrectoExeption(double sueldoBasico) {
        this.sueldoBasico=sueldoBasico;
    }

    /**
     * Obtiene el sueldo que caus� la excepci�n.
     * 
     * @return El sueldo que caus� la excepci�n.
     */
    public double getSueldoBasico() {
        return sueldoBasico;
    }

    @Override
    public String toString() {
        return "El sueldo basico debe ser un valor mayor o igual a 0";
    }
    
}
