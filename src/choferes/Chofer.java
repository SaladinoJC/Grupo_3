package choferes;

import java.util.Objects;

public abstract class Chofer{
    protected String nombre;
    protected  String DNI;
    protected double sueldoBasico;
    protected int puntaje;
    protected double kmRecorridos;

    
    public Chofer(String nombre, String DNI, double sueldoBasico) {
        this.nombre = nombre;
        if(DNI.length()==7)
            this.DNI = DNI;
        else
            //exepcion
        if(sueldoBasico >=0)
            this.sueldoBasico = sueldoBasico;
        else
            //exepcion
        this.puntaje = 0;
        this.kmRecorridos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

   public double getSueldoBasico() {
        return sueldoBasico;
   }
   
   //aumenta los km recorridos del chofer en cada viaje
   public void aumentarKmRecorridos(double km){
       this.kmRecorridos+=km;
   }
    
    public int getPuntaje() {
        return puntaje;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    //aumenta el puntaje en cantidad
    public void aumentarPuntaje(int puntaje)
    {
        this.puntaje+=puntaje;
    }

    @Override
    public abstract String toString();
    public abstract double calcularSueldo();

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chofer other = (Chofer) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.DNI, other.DNI);
    }
    
}
