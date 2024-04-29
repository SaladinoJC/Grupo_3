/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package choferes.exepciones;

/**
 *
 * @author manso
 */
public class SueldoBasicoIncorrectoExeption extends Exception{
    protected  double  sueldoBasico;
    public SueldoBasicoIncorrectoExeption(double sueldoBasico) {
        this.sueldoBasico=sueldoBasico;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    @Override
    public String toString() {
        return "el sueldo basico debe ser un valor mayor o igual a 0";
    }
    
}
