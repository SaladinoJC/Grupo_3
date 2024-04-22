package choferes;

public class Contratado extends Chofer {
    private double gananciaViaje;
    private int cantidadViajes;

    public Contratado(double gananciaViaje, String nombre, String DNI) {
        super(nombre, DNI,0);
        if(gananciaViaje >=0)
         this.gananciaViaje = gananciaViaje;
        else
            //lanza una exepcion
    }

    public double getGananciaViaje() {
        return gananciaViaje;
    }

    public void setGananciaViaje(double gananciaViaje) {
        this.gananciaViaje = gananciaViaje;
    }

    public int getCantidadViajes() {
        return cantidadViajes;
    }

    public void setCantidadViajes(int cantidadViajes) {
        this.cantidadViajes = cantidadViajes;
    }

    @Override
    public void setSueldoBasico(double sueldoBasico) {
        if(sueldoBasico >= 0)
            this.sueldoBasico = sueldoBasico;
        else
            //lanza un exepcion
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
