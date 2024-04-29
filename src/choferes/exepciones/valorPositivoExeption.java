/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 *
 * @author manso
 */
public class valorPositivoExeption extends Exception{
    protected int dato;

    public valorPositivoExeption(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return "el valor debe ser un valor entero y positivo";
    }
    
    
    
}
