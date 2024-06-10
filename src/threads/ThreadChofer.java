package threads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

import choferes.Chofer;
import empresa.Sistema;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.ZoneInvalidException;
import interfaces.Controlador;
import util.Util;

public class ThreadChofer extends Thread{
	protected Chofer c;
	protected int cant;
	protected Sistema s;
	Random r = new Random();
	
	public ThreadChofer (Chofer c, int cantmax, Sistema s) {
		this.c=c;
		this.cant=cantmax;
		//this.cant = r.nextInt(cantmax) + 1;
		this.s=s;
	}
	
	@Override
	public void run()
	{
	for (int i=0;i<cant;i++) 
	{
		Util.espera();
		//chequear si hay clientes haciendo pedidos, sino stopear
		try {
			s.GUILLEsa.asignaChofer();
		} catch (NoHayChoferDisponibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.GUILLEsa.finalizaViaje(c);
	}
	Controlador.infoChofer(this.c.getNombre()+"Termino de realizar viajes");
	this.c.setDisponible(false);
	}

	
	
	
}
