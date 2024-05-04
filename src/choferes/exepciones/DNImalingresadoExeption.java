/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 * Excepci�n que se lanza cuando se ingresa un DNI inv�lido.
 * El DNI debe ser un n�mero sin puntos ni comas.
 * 
 * @author manso
 */

public class DNImalingresadoExeption extends Exception{
    protected  String DNI;
    
    /**
     * Construye una nueva excepci�n con el DNI especificado.
     * 
     * @param DNI El DNI que caus� la excepci�n.
     */
    public DNImalingresadoExeption(String DNI) {
        this.DNI=DNI;
    }

    /**
     * Obtiene el DNI que caus� la excepci�n.
     * 
     * @return El DNI que caus� la excepci�n.
     */
    public String getDNI() {
        return this.DNI;
    }

    @Override
    public String toString() {
        return "DNI todo junto y sin puntos o comas";
    }
    
}
