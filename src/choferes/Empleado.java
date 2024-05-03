package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;

/**
 * Clase abstracta que representa a un empleado que es un tipo de chofer.
 * <p>Extiende la clase Chofer.</p>
 * <p>Esta clase lanza las excepciones PorcentajeExeption, DNImalingresadoExeption y SueldoBasicoIncorrectoExeption si los valores ingresados no son v�lidos.</p>
 * 
 */
public abstract class Empleado extends Chofer {
    protected double aportes;
    protected double sueldoBasico;

    /**
     * Constructor de la clase Empleado.
     * 
     * @param aportes	   El porcentaje de aportes del empleado.
     * @param nombre  	   El nombre del empleado.
     * @param DNI     	   El DNI del empleado.
     * @param sueldoBasico El sueldo b�sico del empleado.
     * @throws PorcentajeExeption 			  Si el porcentaje de aportes es inv�lido.
     * @throws DNImalingresadoExeption 		  Si el DNI es inv�lido.
     * @throws SueldoBasicoIncorrectoExeption Si el sueldo b�sico es negativo.
     */
    public Empleado(double aportes, String nombre, String DNI, double sueldoBasico)throws  PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption{
        super(nombre, DNI);
        if(sueldoBasico >=0)
            this.sueldoBasico = sueldoBasico;
        else
            throw new SueldoBasicoIncorrectoExeption(sueldoBasico);
        if( aportes<100 && aportes >=0)
        	this.aportes = aportes;
        else
        	throw new PorcentajeExeption(aportes);
    }
    /**
     * Devuelve el porcentaje de aportes que tiene el empleado.
     * 
     * @return El porcentaje de aportes.
     */
    protected double getAportes() {
        return aportes;
    }

    /**
     * Establece el porcentaje de aportes que tiene el chofer (empleado).
     * 
     * @param aportes El nuevo porcentaje de aportes.
     * @throws PorcentajeExeption Si el porcentaje de aportes es inv�lido.
     */
    protected void setAportes(double aportes)throws PorcentajeExeption{
        if(aportes>=0 && aportes<100)
            this.aportes = aportes;
        else
            throw new PorcentajeExeption(aportes);
    }
    

    /**
     * Retorna el sueldo b�sico del empleado.
     * 
     * @return El sueldo b�sico.
     */
   public double getSueldoBasico() {
        return sueldoBasico;
   }
   
   /**
    * Establece el sueldo b�sico del chofer (empleado).
    * 
    * @param sueldoBasico El nuevo sueldo b�sico.
    * @throws SueldoBasicoIncorrectoExeption Si el sueldo b�sico es inv�lido.
    */
   public void setSueldoBasico(double sueldoBasico) throws SueldoBasicoIncorrectoExeption{
       if(sueldoBasico >= 0)
           this.sueldoBasico = sueldoBasico;
       else
           throw  new SueldoBasicoIncorrectoExeption(sueldoBasico);
   }
}
