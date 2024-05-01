package empresa;

import java.time.*;

public class Pedido implements Cloneable{
	private LocalDate fecha;
    private LocalTime hora;
	private String zona;
	private boolean mascotas;
	private String equipaje;
	private int cantDePasajeros;

    /**
     * @aggregation shared
     */
    private Cliente cliente;
	
	public Pedido(LocalDate fecha, LocalTime hora, String zona, boolean mascotas, String equipaje, int cantDePasajeros, Cliente cliente) {
		if(fecha.getYear()>0)
			this.fecha = fecha;
         else
             //exception
        	 
		this.hora = hora;
		
		if(zona.equalsIgnoreCase("Estandar") || zona.equalsIgnoreCase("Sin asfaltarr") || zona.equalsIgnoreCase("Peligrosa")) 
			this.zona = zona;
		else
			//exception
			
		this.mascotas = mascotas;
		
		if(equipaje.equalsIgnoreCase("Manual") || equipaje.equalsIgnoreCase("Baul"))
			this.equipaje = equipaje;
		else
			//exception
			
		if(cantDePasajeros > 0)
			this.cantDePasajeros = cantDePasajeros;
		else
			//exception
			
		this.cliente = cliente;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

    public LocalTime getHora() {
        return hora;
    }
        
	public String getZona() {
		return zona;
	}
	
	public boolean isMascotas() {
		return mascotas;
	}
	
	public String getEquipaje() {
		return equipaje;
	}
	
	public int getCantDePasajeros() {
		return cantDePasajeros;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

    @Override
    public String toString() {
        return "Pedido {" + "\nfecha: " + fecha +"\nfue a la hora: "+hora+ "\nzona: " + zona + "\nmascotas: " + mascotas + "\nequipaje: " + equipaje + "\ncantDePasajeros: " + cantDePasajeros + "\ncliente " + cliente +" }";
    }

	@Override
	public Object clone(){
		Object pedidoClon=null;
		try {
			pedidoClon = super.clone();
		}
		catch (CloneNotSupportedException e) {
			//ESTE BLOQUE NO SE EJECUTA JAMAS
			e.printStackTrace();
		}
		return pedidoClon;
	}
	
}
