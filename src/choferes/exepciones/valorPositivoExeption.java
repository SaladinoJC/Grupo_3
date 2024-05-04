/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 * Excepción que se lanza cuando se ingresa un valor invalido.
 * El valor debe ser un numero entero y positivo
 * 
 * @author manso
 */
public class valorPositivoExeption extends Exception{
    protected int dato;

    /**
     * Construye una nueva excepción con el valor especificado.
     * 
     * @param dato El dato que causó la excepción.
     */
    public valorPositivoExeption(int dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el dato que causó la excepción.
     * 
     * @return El dato que causó la excepción.
     */
    public int getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return "El valor debe ser un numero entero y positivo";
    }
    
    
    
}
