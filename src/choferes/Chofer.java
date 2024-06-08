package choferes;

import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import java.util.Objects;
/**
 * Clase abstracta que representa a un chofer.
 * Esta clase es abstracta y proporciona m�todos base comunes para todos los tipos de choferes.
 * Las clases hijas deben implementar los m�todos abstractos para definir comportamientos espec�ficos.
 * 
 * @author manso
 */
public abstract class Chofer{
    protected String nombre;
    protected String DNI;
    protected int puntaje;
    protected double kmRecorridos;
    protected double sueldo;

    /**
     * Constructor de Chofer.
     * 
     * @param nombre El nombre del chofer.
     * @param DNI El n�mero de DNI del chofer.
     * @throws DNImalingresadoExeption Si el formato del DNI no es v�lido.
     */
    public Chofer(String nombre, String DNI)throws DNImalingresadoExeption{
        this.nombre = nombre;
        if(DNI.length()==8)
            this.DNI = DNI;
        else
            throw new DNImalingresadoExeption(DNI);
        this.puntaje = 0;
        this.kmRecorridos = 0;
    }
    /**
     * Obtiene el nombre del chofer.
     * 
     * @return El nombre del chofer.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el n�mero de DNI del chofer.
     * 
     * @return El n�mero de DNI del chofer.
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Incrementa los kil�metros recorridos por el chofer.
     * 
     * @param La cantidad de kil�metros a aumentar.
     */
   public void aumentarKmRecorridos(double km){
       this.kmRecorridos+=km;
   }
   
   /**
    * Obtiene el puntaje del chofer.
    * 
    * @return El puntaje del chofer.
    */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Establece el puntaje del chofer.
     * 
     * @param puntaje El nuevo puntaje del chofer.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    

    /**
     * Aumenta el puntaje del chofer.
     * 
     * @param puntaje La cantidad de puntos a aumentar.
     */
    public void aumentarPuntaje(int puntaje)
    {
        this.puntaje+=puntaje;
    }

    @Override
    public abstract String toString();

    /**
     * M�todo abstracto para obtener el sueldo del chofer.
     * 
     * @return El sueldo del chofer.
     */
    public abstract double getSueldo();
    
    
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
