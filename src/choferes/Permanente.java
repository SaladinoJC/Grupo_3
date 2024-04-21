package choferes;
import java.util.Date;

public class Permanente extends Empleado {
    private double plusXantiguedad;
    private double plusXhijos;
    private int cantHijos;
    Date fechaIngreso;

    public Permanente(double plusXantiguedad, double plusXhijos, int cantHijos, Date fechaIngreso, double aportes, String nombre, String DNI, double sueldoBasico) {
        super(aportes, nombre, DNI, sueldoBasico);
        if(plusXantiguedad >=0 && plusXhijos >=0 && cantHijos >= 0)
        {
            this.plusXantiguedad = plusXantiguedad;
            this.plusXhijos = plusXhijos;
            this.cantHijos = cantHijos;
        }
        else
            //lanzar una exepcion
        this.fechaIngreso = fechaIngreso;
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

    public Date getFechaIngreso() {
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
        return "Permanente nombre:"+getNombre()+"\nDNI:"+getDNI()+"\nsueldo:"+calcularSueldo()
                +"\npuntaje:"+getPuntaje()+"\nplus x antiguedad"+getPlusXantiguedad()+"\nplus x hijos"+getPlusXhijos()
                +"\ncantidad de hijos"+getCantHijos()+"\nfecha de ingreso"+getFechaIngreso();
    }

    @Override
    protected double calcularSueldo() {
            double aux=getSueldoBasico();
            
            aux+=aux*(plusXantiguedad/100);
            aux+=aux*((plusXhijos/100)*cantHijos);
            
            aux-=aux*getAportes();
            
            return aux;
    }
    
    
    
    
}
