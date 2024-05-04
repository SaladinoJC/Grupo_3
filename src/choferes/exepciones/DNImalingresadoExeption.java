/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 * Excepción que se lanza cuando se ingresa un DNI inválido.
 * El DNI debe ser un número sin puntos ni comas.
 * 
 * @author manso
 */

public class DNImalingresadoExeption extends Exception{
    protected  String DNI;
    
    /**
     * Construye una nueva excepción con el DNI especificado.
     * 
     * @param DNI El DNI que causó la excepción.
     */
    public DNImalingresadoExeption(String DNI) {
        this.DNI=DNI;
    }

    /**
     * Obtiene el DNI que causó la excepción.
     * 
     * @return El DNI que causó la excepción.
     */
    public String getDNI() {
        return this.DNI;
    }

    @Override
    public String toString() {
        return "DNI todo junto y sin puntos o comas";
    }
    
}
