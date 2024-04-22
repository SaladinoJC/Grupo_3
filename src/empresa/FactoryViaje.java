package empresa;

import choferes.Chofer;

public class FactoryViaje {

	public TipoDeViaje getViaje (Pedido pedido, Chofer chofer, double distanciaRealRecorrida, double precioBase) {
		TipoDeViaje componenteConc=new Viaje(pedido, chofer, distanciaRealRecorrida, precioBase), encapsuladoMascota=null, encapsuladoEquipaje=null, encapsuladoZona=null;
		
		if(pedido.getZona().equalsIgnoreCase("Estandar"))
			encapsuladoZona=new Estandar(componenteConc);
		else
			if(pedido.getZona().equalsIgnoreCase("Sin asfaltar"))
				encapsuladoZona=new SinAsfaltar(componenteConc);
			else
				if(pedido.getZona().equalsIgnoreCase("Peligrosa"))
					encapsuladoZona=new Peligrosa(componenteConc);
		
		if(encapsuladoZona!=null) {
			if(pedido.getEquipaje().equalsIgnoreCase("Manual"))
				encapsuladoEquipaje=new DeMano(encapsuladoZona);
			else
				if(pedido.getZona().equalsIgnoreCase("Baul"))
					encapsuladoEquipaje=new Baul(encapsuladoZona);
		}
		
		if(encapsuladoEquipaje!=null) {
			if(pedido.isMascotas()==true)
				encapsuladoMascota=new ConMascota(encapsuladoEquipaje);
			else
				if(pedido.isMascotas()==false)
					encapsuladoMascota=new SinMascota(encapsuladoEquipaje);
		}
		
		return encapsuladoMascota;
	}
}
