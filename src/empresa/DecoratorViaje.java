package empresa;


/**
 * La clase abstracta DecoratorViaje es una implementaci�n de TipoDeViaje que act�a como un decorador para tipos de viaje.
 * Proporciona m�todos para obtener y establecer el tipo de viaje decorado.
 */

public abstract class DecoratorViaje implements TipoDeViaje {
    /**
     * El tipo de viaje decorado.
     */
	protected TipoDeViaje tipoDeViaje;

    /**
     * Obtiene el tipo de viaje.
     * 
     * @return El tipo de viaje.
     */
	public TipoDeViaje getTipoDeViaje() {
		return tipoDeViaje;
	}

    /**
     * Establece el tipo de viaje.
     * 
     * @param tipoDeViaje El tipo de viaje a decorar.
     */
	public void setTipoDeViaje(TipoDeViaje tipoDeViaje) {
		this.tipoDeViaje = tipoDeViaje;
	}
	
	@Override
	public Object clone(){
		//La clase DecoratorViaje SIEMPRE sera cloneable
		
		DecoratorViaje decoratorClon=null;
		try {
			decoratorClon = (DecoratorViaje)super.clone();
		}
		catch (CloneNotSupportedException e) {
			//ESTE BLOQUE NO SE EJECUTA JAMAS
			e.printStackTrace();
		}
		return decoratorClon;
	}

}
