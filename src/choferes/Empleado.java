package choferes;

public abstract class Empleado extends Chofer {
    protected  double  aportes;

    public Empleado(double aportes, String nombre, String DNI, double sueldoBasico) {
        super(nombre, DNI, sueldoBasico);
        if(aportes > 0)
        	this.aportes = aportes;
        else
        	//lanza excepcion
    }

    protected double getAportes() {
        return aportes;
    }

    protected void setAportes(double aportes) {
        this.aportes = aportes;
    }

}
