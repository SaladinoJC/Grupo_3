package empresa;

import java.time.*;

public class Pedido {
	private LocalDate fecha;
        private LocalTime hora;
	private String zona;
	private boolean mascotas;
	private String equipaje;
	private int cantDePasajeros;
	private Cliente cliente;
	
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
        return "Pedido{" + "\nfecha: " + fecha +"\nfue a la hora: "+hora+ "\nzona: " + zona + "\nmascotas: " + mascotas + "\nequipaje: " + equipaje + "\ncantDePasajeros: " + cantDePasajeros + "\ncliente " + cliente;
    }
	
}
