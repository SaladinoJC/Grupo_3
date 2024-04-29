package choferes;


import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import java.util.Objects;
/**
 * clase chofer
 * @author manso
 */
public abstract class Chofer{
    protected String nombre;
    protected  String DNI;
    protected double sueldoBasico;
    protected int puntaje;
    protected double kmRecorridos;

    
    public Chofer(String nombre, String DNI, double sueldoBasico)throws DNImalingresadoExeption,SueldoBasicoIncorrectoExeption{
        this.nombre = nombre;
        if(DNI.length()==7)
            this.DNI = DNI;
        else
            throw  new DNImalingresadoExeption(DNI);
        if(sueldoBasico >=0)
            this.sueldoBasico = sueldoBasico;
        else
            throw new SueldoBasicoIncorrectoExeption(sueldoBasico);
        this.puntaje = 0;
        this.kmRecorridos = 0;
    }
    /**
     * 
     * @return String nombre 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @return string DNI
     */
    public String getDNI() {
        return DNI;
    }
    /**
     * 
     * @return double sueldo
     */
   public double getSueldoBasico() {
        return sueldoBasico;
   }
   
  /**
   * incremente los km recorridos de un chofer
   * @param km 
   */
   public void aumentarKmRecorridos(double km){
       this.kmRecorridos+=km;
   }
    /**
     * 
     * @return int el puntaje del chofer 
     */
    public int getPuntaje() {
        return puntaje;
    }
    /**
     * setea el sueldo basico de chofer
     * @param sueldoBasico 
     * @throws choferes.exepciones.SueldoBasicoIncorrectoExeption 
     */
    public void setSueldoBasico(double sueldoBasico) throws SueldoBasicoIncorrectoExeption{
        if(sueldoBasico >= 0)
            this.sueldoBasico = sueldoBasico;
        else
            throw  new SueldoBasicoIncorrectoExeption(sueldoBasico);
    }
    /**
     * setea el puntaje del chofer
     * @param puntaje int
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    /**
     * aumenta el puntaje una x cantidad
     * @param puntaje 
     */
    public void aumentarPuntaje(int puntaje)
    {
        this.puntaje+=puntaje;
    }

    @Override
    public abstract String toString();
    /**
     * calcula el sueldo de cada chofer
     * @return double sueldo del chofer
     */
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
