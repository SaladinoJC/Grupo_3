/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 *
 * @author manso
 */
public class DNImalingresadoExeption extends Exception{
    protected  String DNI;
    public DNImalingresadoExeption(String DNI) {
        this.DNI=DNI;
    }

   
    public String getDNI() {
        return this.DNI;
    }

    @Override
    public String toString() {
        return "DNI todo junto y sin puntos o comas";
    }
    
    
}
