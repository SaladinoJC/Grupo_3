package threads;

import empresa.Cliente;
import empresa.Pedido;
import empresa.Sistema;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.NoHayVehiculoDisponibleException;
import empresa.excepciones.ZoneInvalidException;
import interfaces.Controlador;
import util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Random;

public class ThreadCliente extends Thread{
	protected Cliente c;
	protected int cant;
	protected int zona;
	protected int baul;
	protected int mascota;
	protected int pasajeros;
	protected Sistema s;
	Random r = new Random();
	
	public ThreadCliente (Cliente c, int cantmax, Sistema s) {
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
		this.zona= r.nextInt(2);
		this.baul= r.nextInt(1);
		this.mascota= r.nextInt(1);
		this.pasajeros= r.nextInt(9)+1;
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		LocalDate fechaActual = fechaHoraActual.toLocalDate();
        LocalTime horaActual = fechaHoraActual.toLocalTime();
		Pedido p;
		try {
			p = this.s.GUILLEsa.creapedido(zona, baul, mascota, pasajeros, c, horaActual, fechaActual);
			Boolean estadoVehiculo = false;
			estadoVehiculo=s.dispVehiculo(p);
			if (estadoVehiculo) {
				//chequear si hay choferes trabajando, sino stopear
				this.s.solicitaviaje(p, c);
				this.s.pagaviaje(c);
			}
		} catch (DateInvalidException | ZoneInvalidException | LuggageInvalidException e) {
			e.printStackTrace();
		} catch (NoHayChoferDisponibleException e) {
			e.printStackTrace();
		}
	}
	if (this.c.getNombreReal().equals("Cliente Tres"))
	Controlador.infoCliente(this.c.getNombreReal()+"Termino de hacer pedidos");
	}

	
	
	
}
