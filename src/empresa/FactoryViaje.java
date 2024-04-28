package empresa;

import choferes.Chofer;
import vehiculos.Vehiculo;

public class FactoryViaje {

	public TipoDeViaje getViaje (Pedido pedido, Chofer chofer, double distanciaRealRecorrida, Vehiculo vehiculo) {
		TipoDeViaje componenteConc=null, encapsuladoMascota=null, encapsuladoEquipaje=null;
		
		if(pedido.getZona().equalsIgnoreCase("Estandar"))
			componenteConc=new Estandar(pedido, chofer, distanciaRealRecorrida,vehiculo);
		else
			if(pedido.getZona().equalsIgnoreCase("Sin asfaltar"))
				componenteConc=new SinAsfaltar(pedido, chofer, distanciaRealRecorrida,vehiculo);
			else
				if(pedido.getZona().equalsIgnoreCase("Peligrosa"))
					componenteConc=new Peligrosa(pedido, chofer, distanciaRealRecorrida,vehiculo);
		
		if(componenteConc!=null) {
			if(pedido.getEquipaje().equalsIgnoreCase("Manual"))
				encapsuladoEquipaje=new DeMano(componenteConc);
			else
				if(pedido.getZona().equalsIgnoreCase("Baul"))
					encapsuladoEquipaje=new Baul(componenteConc);
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
