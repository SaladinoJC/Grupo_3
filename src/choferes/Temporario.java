package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import choferes.exepciones.valorPositivoExeption;

/**
 * Representa un chofer contratado temporalmente.
 * Extiende de la clase empleado.
 * Esta clase lanza las excepciones PorcentajeExeption, SueldoBasicoIncorrectoExeption y valorPositivoExeption si los valores ingresados no son válidos.
 */

public class Temporario extends Empleado {
    private double plusXcantViajes;
    private int cantViajes;

    /**
     * Constructor de la clase Temporario.
     * 
     * @param plusXcantViajes 	El porcentaje que recibe por cada viaje realizado.
     * @param aportes 			El porcentaje de aportes que debe realizar.
     * @param nombre 			El nombre del chofer.
     * @param DNI 				El DNI del chofer.
     * @param sueldoBasico 		El sueldo básico del chofer.
     * @throws PorcentajeExeption 				Si el porcentaje es negativo.
     * @throws DNImalingresadoExeption 			Si el DNI ingresado es incorrecto.
     * @throws SueldoBasicoIncorrectoExeption 	Si el sueldo básico es negativo.
     */
    public Temporario(double plusXcantViajes, double aportes, String nombre, String DNI, double sueldoBasico) throws PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption {
        super(aportes, nombre, DNI, sueldoBasico);
        if(plusXcantViajes>=0)
            this.plusXcantViajes = plusXcantViajes;
        else
            throw  new PorcentajeExeption(plusXcantViajes);
        this.cantViajes=0;
    }

    /**
     * Obtiene el porcentaje que recibe por cantidad de viajes.
     * 
     * @return El porcentaje que obtiene por cantidad de viajes.
     */
    public double getPlusXcantViajes() {
        return plusXcantViajes;
    }
    
    /**
     * Obtiene la cantidad de viajes realizados.
     * 
     * @return La cantidad de viajes.
     */
    public int getCantViajes() {
        return cantViajes;
    }

    /**
     * Setea el porcentaje que recibe por cantidad de viajes realizados.
     * 
     * @param plusXcantViajes El porcentaje por cantidad de viajes.
     * @throws PorcentajeExeption Si el porcentaje es negativo.
     */
    public void setPlusXcantViajes(double plusXcantViajes)throws PorcentajeExeption{
        if(plusXcantViajes>=0)
            this.plusXcantViajes = plusXcantViajes;
        else
            throw new PorcentajeExeption(plusXcantViajes);
    }

    /**
     * Setea la cantidad de viajes realizados.
     * 
     * @param cantViajes La cantidad de viajes.
     */
    public void setCantViajes(int cantViajes) {
        assert (cantViajes>=0):"cantidad de viajes negativa";
        this.cantViajes = cantViajes;
    }

    /**
     * Aumenta la cantidad de viajes realizados por un cierto valor.
     * 
     * @param cantidad La cantidad de viajes a incrementar.
     * @throws valorPositivoExeption Si la cantidad de viajes es negativa.
     */
    public void  aumentarCantidadViajes(int cantidad)throws valorPositivoExeption
    {
        if(cantidad>0)
            this.cantViajes+=cantidad;
        else
            throw new valorPositivoExeption(cantidad);
    }

    @Override
    public String toString() {
        return "Temporario\nnombre+"+getNombre()+"\nDNI:"+getDNI()+"\nSueldo:"+getSueldo()
         +"\npuntaje:"+getPuntaje()+"\naportes:"+getAportes()+"\nplus por cantidad de viajes:"+getPlusXcantViajes()
         +"\ncantidad de viajes realizados;"+getCantViajes();   
    }   

    /**
     * Obtiene el sueldo del chofer temporario.
     *  
     * @return El sueldo calculado del chofer temporario.
     */
    @Override
    public double getSueldo() {
        double aux=getSueldoBasico();
        if (cantViajes>20)
        aux+=aux*(plusXcantViajes/100);
        aux-=aux*getAportes();
        return aux;
    }
    
}
