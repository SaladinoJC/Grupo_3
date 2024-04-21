package choferes;

public class Temporario extends Empleado {
    private double plusXcantViajes;
    private int cantViajes;

    public Temporario(double plusXcantViajes, double aportes, String nombre, String DNI, double sueldoBasico) {
        super(aportes, nombre, DNI, sueldoBasico);
        if(plusXcantViajes>=0)
            this.plusXcantViajes = plusXcantViajes;
        else
            //lanza una exepcion
        this.cantViajes=0;
    }

    public double getPlusXcantViajes() {
        return plusXcantViajes;
    }

    public int getCantViajes() {
        return cantViajes;
    }

    public void setPlusXcantViajes(double plusXcantViajes) {
        this.plusXcantViajes = plusXcantViajes;
    }

    public void setCantViajes(int cantViajes) {
        this.cantViajes = cantViajes;
    }
    
    public void  aumentarCantidadViajes(int cantidad)
    {
        if(cantidad>0)
            this.cantViajes+=cantidad;
        else
            //lanza una exepcion
    }

    @Override
    public String toString() {
        return "Temporario nombre+"+getNombre()+"\nDNI:"+getDNI()+"\nsueldoBasico:"+calcularSueldo()
         +"\npuntaje:"+getPuntaje()+"\naportes:"+getAportes()+"\nplus por cantidad de viajes:"+getPlusXcantViajes()
         +"cantidad de viajes realizados;"+getCantViajes();   
    }   

    @Override
    public double calcularSueldo() {
        double aux=getSueldoBasico();
        
        aux+=aux*((plusXcantViajes/100)*cantViajes);
        aux-=aux*getAportes();
        
        return aux;
    }
    
}
