package choferes;
import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.FechaMalIngresadaExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import choferes.exepciones.valorPositivoExeption;
import java.time.*;



public class Permanente extends Empleado {
    private double plusXantiguedad;
    private double plusXhijos;
    private int cantHijos;
    LocalDate fechaIngreso;

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
     * 
     * @return  el porcentaje por antiguedad
     */

    public double getPlusXantiguedad() {
        return plusXantiguedad;
    }
    /**
     * 
     * @return el pocentaje por hijos 
     */
    public double getPlusXhijos() {
        return plusXhijos;
    }
    /**
     * 
     * @return la cantidad de hijos
     */
    public int getCantHijos() {
        return cantHijos;
    }
    /**
     * 
     * @return (LocalDate) la fecha de ingreso 
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    /**
     * setea el pus por antiguedad
     * @param plusXantiguedad 
     */
    public void setPlusXantiguedad(double plusXantiguedad)throws PorcentajeExeption{
        if(plusXantiguedad >= 0)
            this.plusXantiguedad = plusXantiguedad;
        else
            throw new PorcentajeExeption(plusXantiguedad);
    }
    /**
     * setea el plus por hijos
     * @param plusXhijos 
     */
    public void setPlusXhijos(double plusXhijos)throws PorcentajeExeption{
        if(plusXhijos >= 0)
            this.plusXhijos = plusXhijos;
        else
            throw new PorcentajeExeption(plusXhijos);
    }
    /**
     * setea la cantidad de hijos
     * @param cantHijos 
     */
    public void setCantHijos(int cantHijos)throws valorPositivoExeption{
        if(cantHijos >= 0)
            this.cantHijos = cantHijos;
        else
            throw new valorPositivoExeption(cantHijos);
                    
    }
    
    

    @Override
    public String toString() {
        return "Permanente\nnombre:"+getNombre()+"\nDNI:"+getDNI()+"\nsueldo basico:"+getSueldoBasico()+"\nsueldo:"+getSueldo()
                +"\npuntaje:"+getPuntaje()+"\nplus x antiguedad"+getPlusXantiguedad()+"\nplus x hijos"+getPlusXhijos()
                +"\ncantidad de hijos"+getCantHijos()+"\nfecha de ingreso"+getFechaIngreso();
    }

    @Override
    public double getSueldo() {
        double aux=getSueldoBasico();
        System.out.println("el sueldo basico en calcular sueldo es"+ aux);
        aux+=aux*(plusXantiguedad/100);
        System.out.println("aux en calcular sueldo es"+ aux);
        aux+=aux*((plusXhijos/100)*cantHijos);
        System.out.println("aux2 en calcular sueldo es"+ aux);
        aux-=aux*getAportes();
        System.out.println("auxfinal en calcular sueldo es"+ aux);
            
        return aux;
    }
    
}
