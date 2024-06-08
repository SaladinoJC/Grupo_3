package empresa;

import choferes.Chofer;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import empresa.excepciones.ChoferExistenteException;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.ClienteNoExistenteExeption;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.NoHayVehiculoDisponibleException;
import interfaces.Controlador;
import persistencia.ParametrosIniciales;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import vehiculos.Vehiculo;
import vehiculos.exepciones.VehiculoExistenteException;


/**
 * La clase Sistema representa el sistema principal de la empresa.
 * Contiene una referencia a la empresa y al administrador del sistema.
 * Implementa manejoDeListas que tiene todos los metodos de empresa.
 */
public class Sistema extends  Observable implements ManejoDeListas{
    private static Sistema referencia=null;

    /**
     * @aggregation composite
     */
    public Empresa GUILLEsa;

    /**
     * @aggregation composite
     */
    private Administrador admin;
    
    /**
     * Constructor de la clase Sistema.
     * 
     * @param admin El administrador del sistema.
     */
    public Sistema(Administrador admin)
    {
        
        this.GUILLEsa=Empresa.getReferencia();
        this.admin=admin;
        addObserver(Controlador.getReferencia());
    }
 
    /**
     * Obtiene una referencia al sistema.
     * Si no existe una referencia, se crea una nueva instancia del sistema con un administrador predeterminado.
     * 
     * @return Una referencia al sistema.
     */
    public static Sistema getReferencia()
    {
        if(referencia == null)
        {   
            referencia=new Sistema(new Administrador("nombre","admin","admin"));
        }
        return referencia;
    }

	@Override
	public String toString() {
		return "Sistema [GUILLEsa=" + GUILLEsa + ", admin=" + admin + "]";
	}

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
    }
        
     
        
        
    @Override
    public void insertarChofer(Chofer chofer) throws ChoferExistenteException {
        GUILLEsa.insertarChofer(chofer);
        setChanged();
        notifyObservers(chofer);
    }

    @Override
    public boolean buscarChofer(Chofer chofer) {
         return GUILLEsa.buscarChofer(chofer);
    }

    @Override
    public Chofer buscarXchofer(Chofer chofer) {
        return GUILLEsa.buscarXchofer(chofer);
    }

    @Override
    public Chofer getChofer(int index) {
        return GUILLEsa.getChofer(index);
    }

    @Override
    public String ListarChoferes() throws SueldoBasicoIncorrectoExeption{
        return GUILLEsa.ListarChoferes();
        
    }

    @Override
    public String ListarViajesXchofer(Chofer chofer, LocalDate inicio, LocalDate fin) {
        return GUILLEsa.ListarViajesXchofer(chofer, inicio, fin);
    }

    @Override
    public Vehiculo getVehiculo(int index) {
        return GUILLEsa.getVehiculo(index);
    }

    @Override
    public String ListarVehiculos() {
        return GUILLEsa.ListarVehiculos();
    }

    @Override
    public boolean buscarVehiculo(Vehiculo vehiculo) {
         return GUILLEsa.buscarVehiculo(vehiculo);
    }

    @Override
    public Vehiculo buscarXVehiculo(Vehiculo vehiculo) {
       return GUILLEsa.buscarXVehiculo(vehiculo);
    }

    @Override
    public void insertarVehiculo(Vehiculo vehiculo) throws VehiculoExistenteException {
        GUILLEsa.insertarVehiculo(vehiculo);
        setChanged();
        notifyObservers(vehiculo);
    }

    @Override
    public Cliente getCliente(int index) {
       return GUILLEsa.getCliente(index);
    }

    @Override
    public String ListarClientes() {
        return GUILLEsa.ListarClientes();
    }

    @Override
    public boolean buscarCliente(Cliente cliente) {
        return GUILLEsa.buscarCliente(cliente);
    }

    @Override
    public Cliente buscarXcliente(Cliente cliente) throws ClienteNoExistenteExeption{
        return GUILLEsa.buscarXcliente(cliente);
    }

    @Override
    public String ListarViajesXcliente(Cliente cliente, LocalDate inicio, LocalDate fin) throws ClienteNoExistenteExeption{
        return GUILLEsa.ListarViajesXcliente(cliente, inicio, fin);
    }

    @Override
    public void mueveChofer() {
      GUILLEsa.mueveChofer();
   }
    
    @Override
     public void insertarCliente(Cliente cliente) throws ClienteExistenteException {
       GUILLEsa.insertarCliente(cliente);
       setChanged();
       notifyObservers(cliente);
    }

    @Override
    public TipoDeViaje getViaje(int index) {
       return GUILLEsa.getViaje(index);
    }

    @Override
    public void setViaje(TipoDeViaje viaje) {
    	GUILLEsa.setViaje(viaje);
        setChanged();
        notifyObservers(viaje);
    }

    @Override
     public void setiarSueldoContratados() throws SueldoBasicoIncorrectoExeption {
        GUILLEsa.setiarSueldoContratados();
    }

    @Override
    public void setiarCantidadViajesTemporarios() {
       GUILLEsa.setiarCantidadViajesTemporarios();
    }

    @Override
    public void calculoDePuntaje() {
       GUILLEsa.calculoDePuntaje();
    }

    @Override
    public double TotalPagar() throws SueldoBasicoIncorrectoExeption {
        return GUILLEsa.TotalPagar();
    }

    @Override
    public Chofer asignoChofer() throws NoHayChoferDisponibleException {
        return GUILLEsa.asignoChofer();
    }

    @Override
    public void dispVehiculo(Pedido p, Boolean estadoVehiculo) throws NoHayVehiculoDisponibleException {
       GUILLEsa.dispVehiculo(p, estadoVehiculo);;
    }

    @Override
    public double getDistancia() {
       return GUILLEsa.getDistancia();
    }

    @Override
    public Vehiculo asignoVehiculo(Pedido p) {
         return GUILLEsa.asignoVehiculo(p);
    }

	public String ListarViajes() {
		return GUILLEsa.ListarViajes();
	}

	public String ordenarViajesXCostos() {
		return GUILLEsa.ordenarViajesXCostos();
	}

	@Override
	public ArrayList<Cliente> getClientes() {
		return GUILLEsa.getClientes();
	}

	@Override
	public void setClientes(ArrayList<Cliente> clientes) {
		GUILLEsa.setClientes(clientes);
	}

	@Override
	public ArrayList<Chofer> getChoferes() {
		return GUILLEsa.getChoferes();
	}

	@Override
	public void setChoferes(ArrayList<Chofer> choferes) {
		GUILLEsa.setChoferes(choferes);
	}

	@Override
	public ArrayList<TipoDeViaje> getViajes() {
		return GUILLEsa.getViajes();
	}

	@Override
	public void setViajes(ArrayList<TipoDeViaje> viajes) {
		GUILLEsa.setViajes(viajes);
	}

	@Override
	public ArrayList<Vehiculo> getVehiculos() {
		return GUILLEsa.getVehiculos();
	}

	@Override
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		GUILLEsa.setVehiculos(vehiculos);
	}

	@Override
	public void persistirInformacion(int cantClientes, int cantMaximaViajesPorCliente, int cantChoferesDeCadaTipo, int cantMaximaViajesPorChofer, int cantMaximaVehiculosDeCadaTipo) throws IOException {
		GUILLEsa.persistirInformacion(cantClientes, cantMaximaViajesPorCliente, cantChoferesDeCadaTipo, cantMaximaViajesPorChofer, cantMaximaVehiculosDeCadaTipo);
	}

	@Override
	public ParametrosIniciales despersistirInformacion() throws IOException, ClassNotFoundException {
		return GUILLEsa.despersistirInformacion();
	}
    
}
