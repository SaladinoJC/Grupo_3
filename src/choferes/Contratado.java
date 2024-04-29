package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;

public class Contratado extends Chofer {
    private double gananciaViaje;
    private int cantidadViajes;

    public Contratado(double gananciaViaje, String nombre, String DNI)throws PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption{
        super(nombre, DNI,0);
        if(gananciaViaje >=0)
         this.gananciaViaje = gananciaViaje;
        else
            throw  new PorcentajeExeption(gananciaViaje);
    }
    
    /**
     * 
     * @return retorna el porcentaje de ganancia que obtiene por cada viaje 
     */
    
    public double getGananciaViaje() {
        return gananciaViaje;
    }
    /**
     * setea el pocentaje de ganancia que gana en cada viaje
     * @param gananciaViaje 
     * @throws choferes.exepciones.PorcentajeExeption 
     */
    public void setGananciaViaje(double gananciaViaje)throws PorcentajeExeption{
        if(gananciaViaje>=0)
            this.gananciaViaje = gananciaViaje;
        else
            throw new PorcentajeExeption(gananciaViaje);
    }
    /**
     * 
     * @return la cantidad de viajes realizados
     */
    public int getCantidadViajes() {
        return cantidadViajes;
    }
    /**
     * setea la cantidad de viajes realizados 
     * @param cantidadViajes 
     */
    public void setCantidadViajes(int cantidadViajes) {
        this.cantidadViajes = cantidadViajes;
    }

    @Override
    public void setSueldoBasico(double sueldoBasico)throws SueldoBasicoIncorrectoExeption{
        if(sueldoBasico >= 0)
            this.sueldoBasico = sueldoBasico;
        else
            throw new SueldoBasicoIncorrectoExeption(sueldoBasico);
    }
    
    @Override
    public String toString() {
        return "Contratado\nnombre:"+getNombre()+"\nDNI:"+getDNI()+"\nsueldo:"+calcularSueldo()
        +"\npuntaje:"+getPuntaje()+"\nporcentaje por viaje:"+getGananciaViaje();
    }

    @Override
    public double calcularSueldo() {
      double aux=this.sueldoBasico;
      
      aux+=aux*((this.gananciaViaje/100)*this.cantidadViajes);
      
      return aux;
    }
    
}
