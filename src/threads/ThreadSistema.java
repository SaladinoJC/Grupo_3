package threads;

import java.util.Random;

import choferes.Chofer;
import empresa.Sistema;
import util.Util;

public class ThreadSistema extends Thread {
	protected Sistema s;	
	public ThreadSistema (Sistema s) {
		this.s=s;
	}
	
	@Override
	public void run()
	{
	for (int i=0;i<1000;i++) 
	{
		s.GUILLEsa.asignaVehiculo();
	}
	}

	
	
	
}