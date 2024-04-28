package choferes;
import java.time.*;


public class Permanente extends Empleado {
    private double plusXantiguedad;
    private double plusXhijos;
    private int cantHijos;
    LocalDate fechaIngreso;

    public Permanente(double plusXantiguedad, double plusXhijos, int cantHijos,LocalDate fechaIngreso, double aportes, String nombre, String DNI, double sueldoBasico) {
        super(aportes, nombre, DNI, sueldoBasico);
        if( plusXantiguedad >=0)
            this.plusXantiguedad = plusXantiguedad;
        else
            //lanzar una exepcion
        if(plusXhijos>=0)
            this.plusXhijos=plusXhijos;
        else
            //lanzar una exepcion
         if(cantHijos>=0)
             this.cantHijos=cantHijos;
        else
             //lanza una exepcion
         if(fechaIngreso.getYear()>0)
            this.fechaIngreso=fechaIngreso;
         else
             //lanza una exepcion
    }

    public double getPlusXantiguedad() {
        return plusXantiguedad;
    }

    public double getPlusXhijos() {
        return plusXhijos;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setPlusXantiguedad(double plusXantiguedad) {
        if(plusXantiguedad >= 0)
            this.plusXantiguedad = plusXantiguedad;
        else
            //lanza una exepcion
    }

    public void setPlusXhijos(double plusXhijos) {
        if(plusXhijos >= 0)
            this.plusXhijos = plusXhijos;
        else
            //lanza una exepcion
    }

    public void setCantHijos(int cantHijos) {
        if(cantHijos >= 0)
            this.cantHijos = cantHijos;
        else
            //lanza una exepcion
    }
    
    

    @Override
    public String toString() {
        return "Permanente\nnombre:"+getNombre()+"\nDNI:"+getDNI()+"\nsueldo basico:"+getSueldoBasico()+"\nsueldo:"+calcularSueldo()
                +"\npuntaje:"+getPuntaje()+"\nplus x antiguedad"+getPlusXantiguedad()+"\nplus x hijos"+getPlusXhijos()
                +"\ncantidad de hijos"+getCantHijos()+"\nfecha de ingreso"+getFechaIngreso();
    }

    @Override
    public double calcularSueldo() {
        double aux=getSueldoBasico();
            
        aux+=aux*(plusXantiguedad/100);
        aux+=aux*((plusXhijos/100)*cantHijos);
        aux-=aux*getAportes();
            
        return aux;
    }
    
}
