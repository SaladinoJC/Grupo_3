package empresa;

import java.util.ArrayList;

import choferes.Chofer;

public class Empresa {
	private static Empresa referencia;
	private ArrayList<Cliente>clientes;
	private ArrayList<Chofer>choferes;
	private ArrayList<Viaje>viajes;
	
	
	
	private Empresa() {
		this.choferes=new ArrayList<Chofer>();
		this.clientes=new ArrayList<Cliente>();
		this.viajes=new ArrayList<Viaje>();
		
	}
	
	public static Empresa getReferencia() {
		if(referencia == null)
		{
			referencia=new Empresa();
		}
		return referencia;
	}
	
}
