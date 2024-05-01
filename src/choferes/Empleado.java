package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;

public abstract class Empleado extends Chofer {
    protected  double  aportes;
    protected double sueldoBasico;

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
     * 
     * @return el porcentaje de de aportes que tiene el mepleado
     */
    protected double getAportes() {
        return aportes;
    }
    /**
     * setea el porcentaje de aportes que tiene rl chofer
     * @param aportes 
     * @throws choferes.exepciones.PorcentajeExeption 
     */
    protected void setAportes(double aportes)throws PorcentajeExeption{
        if(aportes>=0 && aportes<100)
            this.aportes = aportes;
        else
            throw new PorcentajeExeption(aportes);
    }
    
    /**
     * 
     * @return double sueldo
     */
   public double getSueldoBasico() {
        return sueldoBasico;
   }
   
   /**
    * setea el sueldo basico de chofer
    * @param sueldoBasico 
    * @throws choferes.exepciones.SueldoBasicoIncorrectoExeption 
    */
   public void setSueldoBasico(double sueldoBasico) throws SueldoBasicoIncorrectoExeption{
       if(sueldoBasico >= 0)
           this.sueldoBasico = sueldoBasico;
       else
           throw  new SueldoBasicoIncorrectoExeption(sueldoBasico);
   }
}
