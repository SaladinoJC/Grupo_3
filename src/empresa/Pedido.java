package empresa;

import java.time.*;

public class Pedido {
	private LocalDateTime fechaYHora;
	private String zona;
	private boolean mascotas;
	private String equipaje;
	private int cantDePasajeros;
	private Cliente cliente;
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
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
	
}
