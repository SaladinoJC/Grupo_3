package empresa;

public abstract class DecoratorViaje implements TipoDeViaje {
	protected TipoDeViaje tipoDeViaje;

	public TipoDeViaje getTipoDeViaje() {
		return tipoDeViaje;
	}

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
