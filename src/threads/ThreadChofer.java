package threads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

import choferes.Chofer;
import empresa.Sistema;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.ZoneInvalidException;
import util.Util;

public class ThreadChofer extends Thread{
	protected Chofer c;
	protected int cant;
	protected Sistema s;
	Random r = new Random();
	
	public ThreadChofer (Chofer c, int cantmax, Sistema s) {
		this.c=c;
		this.cant = r.nextInt(cantmax) + 1;
		this.s=s;
	}
	
	@Override
	public void run()
	{
	for (int i=0;i<cant;i++) 
	{
		Util.espera();
		//chequear si hay clientes haciendo pedidos, sino stopear
		s.GUILLEsa.asignaChofer();
		s.GUILLEsa.finalizaViaje();
	}
	System.out.println(this.c.getNombre()+"Termino de realizar viajes");
	}

	
	
	
}
