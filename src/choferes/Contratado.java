package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;

/**
 * Clase que representa a un chofer contratado.
 * Extiende de la clase chofer.
 * Esta clase lanza las excepciones PorcentajeExeption, DNImalingresadoExeption y SueldoBasicoIncorrectoExeption si los valores ingresados no son v�lidos.
 */

public class Contratado extends Chofer {
    private double gananciaViaje;
    private int cantidadViajes;


    /**
     * Constructor de Chofer Contratado.
     * 
     * @param gananciaViaje El porcentaje de ganancia que obtiene por cada viaje.
     * @param nombre 		El nombre del chofer.
     * @param DNI 			El n�mero de DNI del chofer.
     * @throws PorcentajeExeption 		      Si el porcentaje de ganancia es negativo.
     * @throws DNImalingresadoExeption		  Si el formato del DNI no es v�lido.
     * @throws SueldoBasicoIncorrectoExeption Si el sueldo b�sico es negativo.
     */
    public Contratado(double gananciaViaje, String nombre, String DNI) throws PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption{
        super(nombre, DNI);
        if(gananciaViaje >=0)
         this.gananciaViaje = gananciaViaje;
        else
            throw  new PorcentajeExeption(gananciaViaje);
    }
    
    /**
     * Obtiene el porcentaje de ganancia que obtiene por cada viaje.
     * 
     * @return El porcentaje de ganancia por cada viaje.
     */
    public double getGananciaViaje() {
        return gananciaViaje;
    }

    /**
     * Establece el porcentaje de ganancia por cada viaje.
     * 
     * @param gananciaViaje El nuevo porcentaje de ganancia por cada viaje.
     * @throws choferes.exepciones.PorcentajeExeption Si el porcentaje de ganancia es negativo.
     */
    public void setGananciaViaje(double gananciaViaje) throws PorcentajeExeption{
        if(gananciaViaje>=0)
            this.gananciaViaje = gananciaViaje;
        else
            throw new PorcentajeExeption(gananciaViaje);
    }
 
    /**
     * Obtiene la cantidad de viajes realizados por el chofer.
     * 
     * @return La cantidad de viajes realizados por el chofer.
     */
    public int getCantidadViajes() {
        return cantidadViajes;
    }
    
    /**
     * Establece la cantidad de viajes realizados por el chofer.
     * 
     * @param cantidadViajes La nueva cantidad de viajes realizados por el chofer.
     */
    public void setCantidadViajes(int cantidadViajes) {
        this.cantidadViajes = cantidadViajes;
    }

    /**
     * Establece el sueldo b�sico del chofer contratado.
     * 
     * @param sueldo El nuevo sueldo b�sico del chofer contratado.
     * @throws lanza SueldoBasicoIncorrectoExeption Si el sueldo b�sico es negativo.
     */
    public void setSueldo(double sueldo) throws SueldoBasicoIncorrectoExeption{
        if(sueldo >= 0)
            this.sueldo = sueldo;
        else
            throw new SueldoBasicoIncorrectoExeption(sueldo);
    }
    
    @Override
    public String toString() {
        return "Contratado:"+getNombre()+" -- DNI:"+getDNI()+" -- Sueldo: "+getSueldo()
        + "-- Puntaje:"+getPuntaje()+" -- Porcentaje por viaje:"+getGananciaViaje();
    }

    /**
     * Obtiene el sueldo del chofer contratado.
     *  
     * @return El sueldo del chofer contratado.
     * @throws lanza SueldoBasicoIncorrectoExeption si el sueldo es negativo.
     */
    @Override
    public double getSueldo() {
    double aux = this.sueldo;
      return aux;
    }
    
}
