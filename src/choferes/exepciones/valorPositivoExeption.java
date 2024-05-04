/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 * Excepci�n que se lanza cuando se ingresa un valor invalido.
 * El valor debe ser un numero entero y positivo
 * 
 * @author manso
 */
public class valorPositivoExeption extends Exception{
    protected int dato;

    /**
     * Construye una nueva excepci�n con el valor especificado.
     * 
     * @param dato El dato que caus� la excepci�n.
     */
    public valorPositivoExeption(int dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el dato que caus� la excepci�n.
     * 
     * @return El dato que caus� la excepci�n.
     */
    public int getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return "El valor debe ser un numero entero y positivo";
    }
    
    
    
}
