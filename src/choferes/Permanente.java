package choferes;
import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.FechaMalIngresadaExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import choferes.exepciones.valorPositivoExeption;
import java.time.*;

/**
 * Clase que representa a un empleado permanente, un tipo de chofer.
 * <p>Extiende la clase Empleado.</p>
 * <p>La clase Permanente lanza las excepciones PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption, 
 * valorPositivoExeption y FechaMalIngresadaExeption si los valores ingresados no son v�lidos.</p>
 */
public class Permanente extends Empleado {
    private double plusXantiguedad;
    private double plusXhijos;
    private int cantHijos;
    LocalDate fechaIngreso;

    /**
     * Constructor de la clase Permanente.
     * 
     * @param plusXantiguedad 	El porcentaje por antig�edad.
     * @param plusXhijos 	 	El porcentaje por hijos.
     * @param cantHijos 	 	La cantidad de hijos.
     * @param fechaIngreso 	 	La fecha de ingreso.
     * @param aportes 		 	Los aportes del empleado.
     * @param nombre 		 	El nombre del empleado.
     * @param DNI 			 	El DNI del empleado.
     * @param sueldoBasico	 	El sueldo b�sico del empleado.
     * @throws PorcentajeExeption 				Si el porcentaje por antig�edad o por hijos es inv�lido.
     * @throws DNImalingresadoExeption 			Si el DNI es inv�lido.
     * @throws SueldoBasicoIncorrectoExeption	Si el sueldo b�sico es inv�lido.
     * @throws valorPositivoExeption 			Si la cantidad de hijos es inv�lida.
     * @throws FechaMalIngresadaExeption 		Si la fecha de ingreso es inv�lida.
     */
    public Permanente(double plusXantiguedad, double plusXhijos, int cantHijos,LocalDate fechaIngreso,
                     double aportes, String nombre, String DNI, double sueldoBasico) throws PorcentajeExeption, DNImalingresadoExeption, 
                    SueldoBasicoIncorrectoExeption,valorPositivoExeption,FechaMalIngresadaExeption  {
        super(aportes, nombre, DNI, sueldoBasico);
        if( plusXantiguedad >=0)
            this.plusXantiguedad = plusXantiguedad;
        else
            throw  new PorcentajeExeption(plusXantiguedad);
        if(plusXhijos>=0)
            this.plusXhijos=plusXhijos;
        else
            throw  new PorcentajeExeption(plusXhijos);
         if(cantHijos>=0)
             this.cantHijos=cantHijos;
        else
             throw new valorPositivoExeption(cantHijos);
         if(fechaIngreso.getYear()>0)
            this.fechaIngreso=fechaIngreso;
         else
             throw new FechaMalIngresadaExeption(fechaIngreso);
    }

    /**
     * Devuelve el porcentaje por antig�edad.
     * 
     * @return El porcentaje por antig�edad.
     */
    public double getPlusXantiguedad() {
        return plusXantiguedad;
    }

    /**
     * Devuelve el porcentaje por hijos.
     * 
     * @return El porcentaje por hijos.
     */
    public double getPlusXhijos() {
        return plusXhijos;
    }
    
    /**
     * Devuelve la cantidad de hijos.
     * 
     * @return La cantidad de hijos.
     */
    public int getCantHijos() {
        return cantHijos;
    }
    
    /**
     * Devuelve la fecha de ingreso.
     * 
     * @return (LocalDate) La fecha de ingreso.
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Setea el porcentaje por antig�edad.
     * 
     * @param plusXantiguedad El porcentaje por antig�edad a establecer.
     * @throws PorcentajeExeption Si el porcentaje por antig�edad es negativo.
     */
    public void setPlusXantiguedad(double plusXantiguedad)throws PorcentajeExeption{
        if(plusXantiguedad >= 0)
            this.plusXantiguedad = plusXantiguedad;
        else
            throw new PorcentajeExeption(plusXantiguedad);
    }

    /**
     * Setea el porcentaje por hijos.
     * 
     * @param plusXhijos El porcentaje por hijos a establecer.
     * @throws PorcentajeExeption Si el porcentaje por hijos es negativo.
     */
    public void setPlusXhijos(double plusXhijos)throws PorcentajeExeption{
        if(plusXhijos >= 0)
            this.plusXhijos = plusXhijos;
        else
            throw new PorcentajeExeption(plusXhijos);
    }

    /**
     * Setea la cantidad de hijos.
     * 
     * @param cantHijos La cantidad de hijos a establecer.
     * @throws valorPositivoExeption Si la cantidad de hijos es negativa.
     */
    public void setCantHijos(int cantHijos)throws valorPositivoExeption{
        if(cantHijos >= 0)
            this.cantHijos = cantHijos;
        else
            throw new valorPositivoExeption(cantHijos);
                    
    }
    
    @Override
    public String toString() {
        return "Permanente:"+getNombre()+" -- DNI:"+getDNI()+" -- sueldo basico:"+getSueldoBasico()+" -- sueldo:"+getSueldo()
                +" -- puntaje:"+getPuntaje()+" -- Pantig:"+getPlusXantiguedad()+" -- pxhijos:"+getPlusXhijos()
                +" -- cantidad de hijos:"+getCantHijos()+" -- fecha de ingreso:"+getFechaIngreso();
    }

    /**
     * Calcula el sueldo de un chofer permanente.
     * 
     * @return El sueldo calculado del chofer permanente.
     */
    @Override
    public double getSueldo() {
        double aux=getSueldoBasico();
        aux+=aux*(plusXantiguedad/100);
        aux+=aux*((plusXhijos/100)*cantHijos);
        aux-=aux*getAportes();
        return aux;
    }
    
}
