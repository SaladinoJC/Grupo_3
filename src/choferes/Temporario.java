package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import choferes.exepciones.valorPositivoExeption;

public class Temporario extends Empleado {
    private double plusXcantViajes;
    private int cantViajes;

    public Temporario(double plusXcantViajes, double aportes, String nombre, String DNI, double sueldoBasico) throws PorcentajeExeption, DNImalingresadoExeption, SueldoBasicoIncorrectoExeption {
        super(aportes, nombre, DNI, sueldoBasico);
        if(plusXcantViajes>=0)
            this.plusXcantViajes = plusXcantViajes;
        else
            throw  new PorcentajeExeption(plusXcantViajes);
        this.cantViajes=0;
    }
    /**
     * 
     * @return el pocentaje que obtiene por cantidad de viajes
     */
    public double getPlusXcantViajes() {
        return plusXcantViajes;
    }
    /**
     * 
     * @return la cantidad de viajes 
     */
    public int getCantViajes() {
        return cantViajes;
    }
    /**
     * setea el procentaje que gana por cantidad de viajes
     * @param plusXcantViajes 
     * @throws choferes.exepciones.PorcentajeExeption 
     */
    public void setPlusXcantViajes(double plusXcantViajes)throws PorcentajeExeption{
        if(plusXcantViajes>=0)
            this.plusXcantViajes = plusXcantViajes;
        else
            throw new PorcentajeExeption(plusXcantViajes);
    }
    /**
     * setea la cantidad de viajes que realizo 
     * @param cantViajes 
     */
    public void setCantViajes(int cantViajes) {
        assert (cantViajes>=0):"cantidad de viajes negativa";
        this.cantViajes = cantViajes;
    }
    /**
     * aumenta la cantidad de viajes una cierta cantidad>0
     * @param cantidad 
     * @throws choferes.exepciones.valorPositivoExeption 
     */
    public void  aumentarCantidadViajes(int cantidad)throws valorPositivoExeption
    {
        if(cantidad>0)
            this.cantViajes+=cantidad;
        else
            throw new valorPositivoExeption(cantidad);
    }

    @Override
    public String toString() {
        return "Temporario\nnombre+"+getNombre()+"\nDNI:"+getDNI()+"\nsueldoBasico:"+calcularSueldo()
         +"\npuntaje:"+getPuntaje()+"\naportes:"+getAportes()+"\nplus por cantidad de viajes:"+getPlusXcantViajes()
         +"\ncantidad de viajes realizados;"+getCantViajes();   
    }   

    @Override
    public double calcularSueldo() {
        double aux=getSueldoBasico();
        
        aux+=aux*((plusXcantViajes/100)*cantViajes);
        aux-=aux*getAportes();
        
        return aux;
    }
    
}
