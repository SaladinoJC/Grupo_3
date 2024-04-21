package choferes;

public abstract class Empleado extends Chofer {
    protected  double  aportes;

    public Empleado(double aportes, String nombre, String DNI, double sueldoBasico) {
        super(nombre, DNI, sueldoBasico);
        this.aportes = aportes;
    }

    protected double getAportes() {
        return aportes;
    }

    protected void setAportes(double aportes) {
        this.aportes = aportes;
    }

  
    

}
