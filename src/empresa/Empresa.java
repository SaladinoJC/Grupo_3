package empresa;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import choferes.Chofer;
import choferes.Contratado;
import choferes.Temporario;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import empresa.excepciones.ChoferExistenteException;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.ClienteNoExistenteExeption;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.NoHayVehiculoDisponibleException;
import empresa.excepciones.ZoneInvalidException;
import interfaces.Controlador;
import persistencia.EmpresaDTO;
import persistencia.PersistenciaXML;
import persistencia.IPersistencia;
import persistencia.ParametrosIniciales;
import persistencia.UtilEmpresa;
import vehiculos.FactoryVehiculo;
import vehiculos.Vehiculo;
import vehiculos.exepciones.NoSePuedeCrearVehiculoException;
import vehiculos.exepciones.VehiculoExistenteException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import vehiculos.Vehiculo;

/**
 * La clase Empresa representa todos los datos de la empresa.
 * Puede lanzar excepciones
 */

/**
 * 
 */
public class Empresa extends Observable {
	private static Empresa referencia;

    /**
     * @aggregation composite
     */
    private ArrayList<Cliente>clientes;

    /**
     * @aggregation composite
     */
    private ArrayList<Chofer>choferes;
    
    /**
     * @aggregation shared
     */
    private ArrayList<TipoDeViaje>viajes;

    /**
     * @aggregation composite
     */
    private ArrayList<Vehiculo>vehiculos;
        
    private ArrayList<Pedido>viajesSinVehiculo;
	
    private ArrayList<TipoDeViaje>viajesConVehiculo;
    
    private ArrayList<TipoDeViaje>viajesSinPagar;
    
    private ArrayList<TipoDeViaje>viajesPagados;
    /**
     * Constructor privado de la clase Empresa.
     * Se inicializan las listas de clientes, choferes, viajes y veh�culos.
     */
	public Empresa() {
		this.choferes=new ArrayList<Chofer>();
		this.clientes=new ArrayList<Cliente>();
		this.viajes=new ArrayList<TipoDeViaje>();
        this.vehiculos=new ArrayList<Vehiculo>();
        this.viajesSinVehiculo= new ArrayList<Pedido>();
        this.viajesConVehiculo= new ArrayList<TipoDeViaje>();
        this.viajesSinPagar = new ArrayList<TipoDeViaje>();
        this.viajesPagados = new ArrayList<TipoDeViaje>();
	}
	
	
	/**
	 * Metodo que retorna el ArrayList de los clientes que tiene la empresa
	 * 
	 * @return ArrayList de los clientes que tiene la empresa
	 */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	/**
	 * Metodo que setea el ArrayList de los clientes que tiene la empresa
	 * @param clientes: ArrayList de los clientes de la empresa
	 */
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * Metodo que retorna el ArrayList de los choferes que tiene la empresa
	 * 
	 * @return ArrayList de los choferes que tiene la empresa
	 */
	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	/**
	 * Metodo que setea el ArrayList de los choferes que tiene la empresa
	 * @param choferes: ArrayList de los choferes de la empresa
	 */
	public void setChoferes(ArrayList<Chofer> choferes) {
		this.choferes = choferes;
	}

	/**
	 * Metodo que retorna el ArrayList de los viajes que tiene la empresa
	 * 
	 * @return ArrayList de los viajes que tiene la empresa
	 */
	public ArrayList<TipoDeViaje> getViajes() {
		return viajes;
	}

	/**
	 * Metodo que setea el ArrayList de los viajes que tiene la empresa
	 * @param viajes: ArrayList de los viajes, por parte de los clientes, que tiene la empresa
	 */
	public void setViajes(ArrayList<TipoDeViaje> viajes) {
		this.viajes = viajes;
	}

	/**
	 * Metodo que retorna el ArrayList de los vehiculos que tiene la empresa
	 * 
	 * @return ArrayList de los vehiculos que tiene la empresa
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	/**
	 * Metodo que setea el ArrayList de los vehiculos que tiene la empresa
	 * @param vehiculos: ArrayList de los vehiculos que tiene la empresa
	 */
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


		/**
		 * Metodo para obtener la instancia unica de la clase Empresa (patron singleton).
		 *
		 * @return La instancia unica de la empresa.
		 */
		public static Empresa getReferencia()
        {
			if(referencia == null){
				referencia=new Empresa();
			}
			return referencia;
        }
		
		//CODIGO DE CHOFER
        
	    /**
	     * Inserta un chofer en la lista de choferes de la empresa.
	     * Si el chofer ya existe, lanza una excepci�n.
	     *
	     * @param chofer El chofer a insertar.
	     * @throws ChoferExistenteException 
	     * @throws TODO choferNoExisteException
	     */
        public void insertarChofer(Chofer chofer) throws ChoferExistenteException
        {	if (choferes.isEmpty())
        	setChofer(chofer);
        	else
            if(!buscarChofer(chofer)) 
                setChofer(chofer);
            else
            	throw new ChoferExistenteException(chofer);
        }
        
        /**
         * Busca un chofer en la lista de choferes.
         *
         * @param chofer El chofer a buscar.
         * @return true si el chofer existe, false en caso contrario.
         */
        public boolean buscarChofer(Chofer chofer)
        {
            int i=0;
            Chofer aux=getChofer(i);
            while(i<choferes.size() && !aux.equals(chofer))
            {
                i++;
                if (i<choferes.size())
                aux=getChofer(i);
            }
            return i<choferes.size();
        }
        
        /**
         * Obtiene un chofer si existe.
         *
         * @param chofer El chofer x a buscar.
         * @return El chofer correspondiente si existe, null si no lo encuentra.
         */
        public Chofer buscarXchofer(Chofer chofer)
        {
            Chofer aux;
            int i=0;
            aux=getChofer(i);
            while(i<choferes.size() && !aux.equals(chofer))
            {
                i++;
                aux=getChofer(i);
            }
            if(i<choferes.size())
                return aux;
            else
                return null;
        }
        
        /**
         * Obtiene el chofer indicado segun el parametro 
         * 
         * @param index El indice del chofer.
         * @return El chofer correspondiente del arraylist.
         */
        public Chofer getChofer(int index)
        {
            return choferes.get(index);
        }
        
        /**
         * Inserta un chofer en la lista de choferes.
         * 
         * @param chofer El chofer a insertar.
         */
        private void setChofer(Chofer chofer)
        {
            choferes.add(chofer);
        }
        
        /**
         * Devuelve una cadena con los datos de todos los choferes de la empresa.
         * 
         * @return un string con los datos de todos los choferes
         * @throws SueldoBasicoIncorrectoExeption si ocurre un error al calcular el sueldo b�sico de alg�n chofer.
         */
        public String ListarChoferes() throws SueldoBasicoIncorrectoExeption
        {
            int i;
            Chofer aux;
            String cadena="";
            setiarCantidadViajesTemporarios();
            setiarSueldoContratados();
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i);
                cadena=cadena.concat(aux.toString());
                cadena=cadena.concat("\n");
            }
            return cadena;
        }
        
        public Chofer asignoChofer() throws NoHayChoferDisponibleException{
        	int i=0;
			if (this.choferes.isEmpty())
				 throw new NoHayChoferDisponibleException();
			else
				while(i<this.choferes.size() && !this.choferes.get(i).isDisponible()) {
					i++;
				}
			if (i==this.choferes.size())
				return null;
			else
				return this.getChofer(i);
		}
              

        //CODIGO VEHICULOS
        
        /**
         * Devuelve un vehiculo de la lista segun su indice.
         * 
         * @param index El indice del vehiculo en la lista.
         * @return el vehiculo de la lista en la posicion especificada. 
         */
        public Vehiculo getVehiculo(int index)
        {
            return vehiculos.get(index);
        }
        /**
         * Inserta un vehiculo en la lista de vehiculos.
         * 
         * @param vehiculo El vehiculo que se desea insertar. 
         */
        private void setVehiculo(Vehiculo vehiculo)
        {
            vehiculos.add(vehiculo);
        }
       
        /**
         * Devuelve una cadena con la representaci�n de todos los veh�culos.
         * 
         * @return una cadena con todos los vehiculos.
         */
        public String ListarVehiculos()
        {
            int i;
            Vehiculo aux;
            String cadena="";
            for(i=0;i<vehiculos.size();i++)
            {
                aux=getVehiculo(i);
                cadena=cadena.concat(aux.toString());
                cadena=cadena.concat("\n");
            }
            return cadena;
        }
        
        /**
         * Chequea si hay alguno vehiculo disponible
         * 
         * @param p El pedido que le llega para chequear si hay un auto disponible para ese pedido
         * @throws NoHayVehiculoDisponibleException
         */
		public boolean dispVehiculo(Pedido p) //throws NoHayVehiculoDisponibleException
		{
			int i=0;
			boolean ok=false;
			Vehiculo aux;
			while(i<vehiculos.size()&& !ok)
            {
               aux=getVehiculo(i);
               if ((p.getCantDePasajeros()<=aux.getCantMaxPasajeros())&&((p.isMascotas()==false)||(p.isMascotas()==aux.isPetFriendly()))&&((p.getEquipaje().equalsIgnoreCase("Manual"))||(p.getEquipaje().equalsIgnoreCase("Baul")&&aux.isBaul())))
               ok=true;
               i++;
            }
			if (!ok) {
				return false;
				//throw new NoHayVehiculoDisponibleException();
				}
			else
				return true;
		}
		
        /**
         * Recorre la lista de vehiculos y devuelve el de mayor prioridad
         * 
         * @return 
         */
        public Vehiculo BuscarVehiculoPrioritario(Pedido p){
        	int prioridad = 0, prioridadAct, i=0;
        	Vehiculo act, aux = null;
        	//System.out.println("el pedido es:"+p);
        	while (i<vehiculos.size()) {
        		act = getVehiculo(i);
        		
        		//System.out.println("act es: "+act);
        		if(act.isDisponible())
        		prioridadAct = act.getPrioridad(p); 
        		else
        		prioridadAct= -1;
        		//System.out.println("la prioridad act es: "+prioridadAct);
        		if (prioridadAct > prioridad) {
        			aux = act;
        			prioridad = prioridadAct;
        		}
        		i++;
        	}
           // aux=getVehiculo(prioridad);
        	if (prioridad== -1)
        		return null;
        	else
        		return aux; //Devuelvo un aux aunque no lo haya inicializado porque ya cheque que hay alguno disponible
        }       
        
        
        /**
         * Devuelve el vehiculo con mas prioridad para el pedido recibido por parametro
         * 
         * @return Devuelve el vehiculo a asignar
         */
		public Vehiculo asignoVehiculo(Pedido p) {
			return BuscarVehiculoPrioritario(p);
		}
        
        /**
         * Busca un veh�culo en la lista.
         * 
         * @param vehiculo El veh�culo que se desea buscar.
         * @return true si el veh�culo existe en la lista, false de lo contrario.
         */
        public boolean buscarVehiculo(Vehiculo vehiculo)
        {
            int i=0;
            Vehiculo aux=getVehiculo(i);
            while(i<vehiculos.size() && !aux.equals(vehiculo))
            {
                i++;
                if (i<vehiculos.size())
                aux=getVehiculo(i);
            }
            return i<vehiculos.size();
        }
	
         /**
          * Busca un veh�culo en la lista y devuelve una referencia a �l.
          * 
          * @param vehiculo El veh�culo que se desea buscar.
          * @return el vehiculo encontrado, si no lo encuentra devuelve null.
          */
         public Vehiculo buscarXVehiculo(Vehiculo vehiculo)
        {
            Vehiculo aux;
            int i=0;
            aux=getVehiculo(i);
            while(i<vehiculos.size() && !aux.equals(vehiculo))
            {
                i++;
                aux=getVehiculo(i);
            }
            if(i<vehiculos.size())
                return aux;
            else
                return null;
        }
         
        /**
         * Inserta un veh�culo en la lista de veh�culos, si no existe.
         * 
         * @param vehiculo El veh�culo que se desea insertar.
         * @throws VehiculoExistenteException 
         * @throws TODO IllegalArgumentException si el veh�culo ya existe en la lista.
         */ 
        public void insertarVehiculo(Vehiculo vehiculo) throws VehiculoExistenteException
        {	if(vehiculos.isEmpty()) 
        	setVehiculo(vehiculo);
        	else
            if(!buscarVehiculo(vehiculo))
                setVehiculo(vehiculo);
            else
            {
                //aca va una exepcion
            	throw new VehiculoExistenteException(vehiculo);
            }
        }
        
		/**
		 * Devuelve un numero aletorio para simular las distancias de un viaje. 
		 * 
		 * @return un numero aleatorio entre 1 y 30
		 */
		public double getDistancia() {
			Random random = new Random();
			return random.nextInt(30)+1;
		}
		
   
        //CODIGO DE CLIENTES
		
        /**
         * Obtiene un cliente de la lista seg�n su �ndice.
         * 
         * @param index El �ndice del cliente en la lista.
         * @return devuelve un cliente de la lista en la posici�n especificada.
         */
        public Cliente getCliente(int index)
        {
            return clientes.get(index);
        }
        
        /**
         * Agrega un cliente a la lista de clientes.
         * 
         * @param cliente El cliente que se desea agregar.
         */
        private void setCliente(Cliente cliente)
        {
            clientes.add(cliente);
        }
        
        /**
         * Genera una cadena con la representaci�n de todos los clientes.
         * 
         * @return una cadena con todos los clientes.
         */
        public String ListarClientes()
        {
            int i;
            String cadena="";
            Cliente aux;
            for(i=0;i<clientes.size();i++)
            {
                aux=getCliente(i);
                cadena=cadena.concat(aux.toString());
                cadena=cadena.concat("\n");
            }
            return cadena;
        }
        
        /**
         * Busca un cliente en la lista.
         * 
         * @param cliente El cliente que se desea buscar.
         * @return true si existe el cliente, false si no existe.
         */
        public boolean buscarCliente(Cliente cliente)
        {
            int i=0;
            Cliente aux=getCliente(i);
            while(i<clientes.size() && ! aux.equals(cliente))
            {
                i++;
                if (i<clientes.size())
                aux=getCliente(i);
            }
            return i<clientes.size();
        }
        
        /**
         * Busca un cliente 
         * 
         * @param cliente El cliente que se desea buscar.
         * @return el cliente si lo encuentra, si no lo encuentra lanza una exepcion.
         */
         public Cliente buscarXcliente (Cliente cliente) throws ClienteNoExistenteExeption
        {
            Cliente aux;
            int i=0;
            if(clientes.size()>0)//si no existe la lista no hay ningun cliente
            {
                aux=getCliente(i);
                while(i<clientes.size() && !aux.equals(cliente))
                {
                     i++;
                    aux=getCliente(i);
                }
                if(i<clientes.size())
                    return aux;
                else
                    throw new ClienteNoExistenteExeption(cliente);
            }
            else
                throw  new ClienteNoExistenteExeption(cliente);
        }
         
        /**
         * Genera una cadena con la lista de viajes realizados por un cliente en un rango de fechas.
         * 
         * @param cliente El cliente del cual se desean obtener los viajes.
         * @param inicio La fecha de inicio del rango.
         * @param fin La fecha de fin del rango.
         * @return una cadena que contiene la lista de viajes realizados por el cliente en las fechas indicadas.
         * @throws TODO excepcion si el cliente no existe
         * @throws TODO excepcion fecha de fin con fecha anterior a fecha de inicio o ponerlo en las precondiciones
         */
        public String ListarViajesXcliente(Cliente cliente,LocalDate inicio,LocalDate fin) throws ClienteNoExistenteExeption
        {
            LocalDate fecha;
            TipoDeViaje viaje;
            String cadena="";
            int i;
            if(buscarCliente(cliente) && inicio.isBefore(fin))//busca que el cliente exista y que las fechas esten bien
            {
                for(i=0;i<viajes.size();i++)
                {
                    viaje=getViaje(i);
                    fecha=viaje.getPedido().getFecha();
                    //pregunto que viajes realizo el cliente y si se encuentra entre la fechas de parametros
                    if(viaje.getPedido().getCliente().equals(cliente) && (fecha.isAfter(inicio) && fecha.isBefore(fin) )) //pregunto q viajes realizo este cliente
                    {
                        cadena=cadena.concat(viaje.toString());//almaceno los viajes que realizo
                        cadena=cadena.concat("\n\n");
                    }
                }
            }
            else
                if(!buscarCliente(cliente)) {
                    throw new ClienteNoExistenteExeption(cliente);
                }
                else {
                    //El cliente si existe
                }
             return cadena;
        }
        
        /**
         * Inserta un cliente en la lista si este no existe.
         * 
         * @param cliente El cliente que se desea insertar.
         * @throws ClienteExistenteException 
         * @throws TODO ClienteExistenteException Si el cliente ya existe en la lista.
         */
        public void insertarCliente(Cliente cliente) throws ClienteExistenteException
        {	if(clientes.isEmpty())
        		setCliente(cliente);
        	else
            if(!buscarCliente(cliente))
                setCliente(cliente);
            else
            {
            	// Lanza una excepcion si el cliente ya existe
                throw new ClienteExistenteException(cliente);
            }
        }
        
        //CODIGO DE VIAJE
        
        /**
         * Devuelve una cadena con los viajes realizados por un chofer entre dos fechas.
         * 
         * @param chofer El chofer del cual se desean listar los viajes.
         * @param inicio La fecha de inicio de los viajes.
         * @param fin La fecha de fin de los viajes.
         * @return Una cadena con los viajes realzados por el chofer en el intervalo de tiempo especificado.
         * @throws TODO nombre incorrecto
         * @throws TODO fecha de fin con fecha anterior a fecha de inicio o ponerlo en las precondiciones
         */
        public String ListarViajesXchofer(Chofer chofer,LocalDate inicio,LocalDate fin)
        {
            LocalDate fecha;
            TipoDeViaje viaje;
            String cadena="";
            int i;
            if(buscarChofer(chofer) && inicio.isBefore(fin))//busca que el chofer exista
            {
                for(i=0;i<viajes.size();i++)
                {
                    viaje=getViaje(i);
                    fecha=viaje.getPedido().getFecha();
                    //pregunto que viajes realizo el chofer y si se encuentra entre la fechas de parametros
                    if(viaje.getChofer().equals(chofer) && (fecha.isAfter(inicio) && fecha.isBefore(fin) ))//pregunto q viajes realizo este cliente
                    {
                          cadena=cadena.concat(viaje.toString());
                          cadena=cadena.concat("\n\n");
                    }   
                        
                }
            }
            else
                if(!buscarChofer(chofer)) {
                  	//Excepcion el chofer no existe
                }
                else {
                    //El chofer no existe
                }
            return cadena;
        }
        
        /**
         * Obtiene un viaje de la lista seg�n su �ndice.
         * 
         * @param index El �ndice del viaje en la lista.
         * @return el viaje en la posici�n especificada.
         */
        public TipoDeViaje getViaje(int index)
        {
            return viajes.get(index);
        }
        
        /**
         * Inserta un viaje en la lista de viajes.
         * 
         * @param viaje El viaje que se desea insertar.
         */
        public void setViaje(TipoDeViaje viaje)
        {
            viajes.add(viaje);
        }
        
        /**
         * Genera una cadena de todos los viajes.
         * 
         * @return una cadena con todos los viajes.
         */
        public String ListarViajes()
        {
            int i;
            TipoDeViaje aux;
            String cadena="";
            for(i=0;i<viajes.size();i++)
            {
                aux=viajes.get(i);
                //System.out.println("aux es: "+aux);
                cadena=cadena.concat(aux.toString());
                cadena=cadena.concat("\n");
            }
            return cadena;
        }
         
       /**
        * Ordena los viajes por costos en una lista clonada y genera una cadena con la lista ordenada.
        * 
        * @return una cadena que contiene la lista de viajes ordenados por costo de mayor a menor. 
        */
        public String ordenarViajesXCostos()
        {
            TipoDeViaje aux;
            TipoDeViaje[] clon=clon();//recibe la lista de viajes clonada
            double costo;
            String cadena="";
            int i,j;
            for(i=1;i<viajes.size();i++)//ordenamiento por insercion
            {
                aux=clon[i];
                costo=aux.getCostoTotal();
                j=i-1;
                while(j>=0 && costo<clon[j].getCostoTotal())
                {
                    clon[j+1]=clon[j];
                    j--;
                }
                clon[j+1]=aux;
            }
            for(i=0;i<clon.length;i++)//almacena en una cadena todos los viajes ordenados
            {
                cadena=cadena.concat(clon[i].toString());
                cadena=cadena.concat("\n\n");
            }
            return cadena;//retorna la cadena
        }
        
        /**
         * Clona el ArrayList de viajes y lo almacena en un vector.
         * 
         * @return devuelve la referencia al vector clonado.
         */
        private TipoDeViaje[] clon()
        {
            TipoDeViaje[] vector=null;
            int i;
            try {
            	vector=new TipoDeViaje[viajes.size()];
            	for(i=0;i<viajes.size();i++)
					vector[i]=(TipoDeViaje)viajes.get(i).clone();
			} 
            catch (CloneNotSupportedException e) {
				throw new InternalError(e.toString());
			}
            return vector;
        }
                
        /**
         * Setea la cantidad de viajes que realizaron los temporarios.
         */
        public void setiarCantidadViajesTemporarios()
        {
            Chofer aux;
            Temporario temporario;
            TipoDeViaje viaje;
            int i,j,cont;
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i);
                cont=0;
                if(aux.getClass().getSimpleName().equals("Temporario"))//busco choferes temporarios
                {
                    for(j=0;j<viajes.size();j++)//busco los viajes q realizo dicho chofer temporarios
                    {
                        viaje=getViaje(j);
                        if(viaje.getChofer().equals(aux))//si el chofer temporario realizo este viaje  aumento el contador
                                    cont++; 
                    }     
                   temporario=(Temporario)aux;
                   temporario.setCantViajes(cont);
                }
            }
        }
        
        //RESTO DE CODIGO

        /**
         * Desde la clase Empresa, establece el sueldo de los choferes contratados seg�n la cantidad de viajes que realizaron.
         * @throws TODO SueldoBasicoIncorrectoExeption()
         */
        public void setiarSueldoContratados() throws SueldoBasicoIncorrectoExeption
        {
            Chofer aux;
            Contratado contratado;
            TipoDeViaje viaje;
            double sueldo;
            int i,j,cont;
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i);
                cont=0;sueldo=0;
                if(aux.getClass().getSimpleName().equals("Contratado"))//busco choferes contratados
                {
                    for(j=0;j<viajes.size();j++)//busco los viajes q realizo dicho chofercontratado
                    {
                        viaje=getViaje(j);
                        if(viaje.getChofer().equals(aux))//si el chofer contratado realizo este viaje sumo su costo y aumento el contador
                        {
                            sueldo+=(viaje.getIncKm()+viaje.getIncPax());
                            cont++;
                        }  
                    }     
                    contratado=(Contratado)aux;
                    contratado.setCantidadViajes(cont);
                    contratado.setSueldo(sueldo);
                }
            }
        }
        
        /**
         * Calcula y establece el puntaje de cada chofer.
         */
        public void calculoDePuntaje()
        {
            Chofer aux,mayor = null;
            TipoDeViaje viaje;
            int i,j,cont,max=-1;
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i); //voy cargando cada choffer
                cont=0;
                for(j=0;j<viajes.size();j++) //recorro la lista de viajes
                {
                    viaje=getViaje(j);
                    if(viaje.getChofer().equals(aux)) //si el chofer realizo ese viaje aumento el contador en 1
                            cont++;
                }
                aux.setPuntaje(cont*5); //seteo puntaje del chofer
                if(max<cont) //si es el chofer con mas viajes realizados me lo guardo
                {
                    mayor=aux;
                    max=cont;
                }    
            }
            mayor.aumentarPuntaje(15); //aumento en 15 puntos al chofer que mas viajes realizo
        }
        
        /**
         * Calcula el total a pagar de la empresa en sueldos.
         * 
         * @return Devuelve el total a pagar de la empresa en sueldos.
         * @throws SueldoBasicoIncorrectoExeption Si el calculo del sueldo b�sico es incorrecto.
         */
        public double TotalPagar() throws SueldoBasicoIncorrectoExeption
        {
            Chofer aux;
            int i;
            double total=0;
            setiarSueldoContratados();
            setiarCantidadViajesTemporarios();
            for(i=0;i<choferes.size();i++)
            {
               aux=getChofer(i);
               total+=aux.getSueldo();
            }
            return total;
        }
        
        
        public void mueveChofer() {
        	Chofer aux=this.choferes.remove(0);
        	this.choferes.add(aux);
        }
        
        
        public void persistirInformacion(int cantClientes, int cantMaximaViajesPorCliente, int cantChoferesDeCadaTipo, int cantMaximaViajesPorChofer, int cantMaximaVehiculosDeCadaTipo) throws IOException {
        	IPersistencia persistencia = new PersistenciaXML();
        	persistencia.abrirOutput("DatosDeLaEmpresa.xml");
        	EmpresaDTO edto = UtilEmpresa.empresaDTOfromEmpresa(this, cantClientes, cantMaximaViajesPorCliente, cantChoferesDeCadaTipo, cantMaximaViajesPorChofer, cantMaximaVehiculosDeCadaTipo);
        	persistencia.escribir(edto);
        	persistencia.cerrarOutput();
        	
        }
        
        public ParametrosIniciales despersistirInformacion() throws IOException, ClassNotFoundException {
        	IPersistencia persistencia = new PersistenciaXML();
            persistencia.abrirInput("DatosDeLaEmpresa.xml");
            
            EmpresaDTO edto = (EmpresaDTO) persistencia.leer();
            UtilEmpresa.empresaFromEmpresaDTO(edto,this);
            persistencia.cerrarInput();
			return UtilEmpresa.obtenerParametrosIniciales(edto);
        }
        
    	private void crearViajeSinVehiculo(Pedido p) {
			this.viajesSinVehiculo.add(p);
		}
    	
    	private void crearViajeConVehiculo(Pedido p, Vehiculo v) {
    	TipoDeViaje viaje = FactoryViaje.getViaje(p, null, this.getDistancia(), v);
			this.viajesConVehiculo.add(viaje);
		}
    	
    	private Pedido getPedidoLista() {
    		Pedido p=this.viajesConVehiculo.getFirst().getPedido();
    		return p;
		}
    	
		private Vehiculo getVehiculoLista() {
			Vehiculo v=this.viajesConVehiculo.getFirst().getVehiculo();
			return v;
		}
		
    	private int EstaMiViaje(Cliente c) {
			int i=0;
			while (i<this.viajesSinPagar.size() && !this.viajesSinPagar.get(i).getPedido().getCliente().equals(c))
				i++;
			if (i==this.viajesSinPagar.size())
				return -1;
			else
				return i;
		}
    	
		private int EstaMiViajePagado(Chofer c) {
			int i=0;
			while (i<this.viajesPagados.size() && !this.viajesPagados.get(i).getChofer().equals(c))
				i++;
			if (i==this.viajesPagados.size())
				return -1;
			else
				return i;
		}
        
        
        
        
    	public Pedido creapedido(int zona, int baul, int mascota, int pasajeros, Cliente c, LocalTime horaActual,
    			LocalDate fechaActual) throws DateInvalidException, ZoneInvalidException, LuggageInvalidException {
    		String zonapedido=" ";
    		String baulpedido;
    		Boolean mascotapedido;
    		switch(zona) {
    		case 0:{
    			zonapedido="Sin asfaltar";
    			break;
    		}
    		case 1:{
    			zonapedido="Estandar";
    			break;
    		}
    		case 2:{
    			zonapedido="Peligrosa";
    			break;
    		}
    		}
    		if (baul==1)
    			baulpedido="Baul";
    		else
    			baulpedido="Manual";
    		if(mascota==1)
    			mascotapedido=true;
    		else
    			mascotapedido=false;
    		
    		Pedido p1 = new Pedido(fechaActual, horaActual, zonapedido, mascotapedido, baulpedido, pasajeros, c);
    		return p1;
    	}

    	
    	
    	
    	
    	
    	
    	public synchronized void solicitaviaje(Pedido p, Cliente c) throws NoHayChoferDisponibleException{
    		while (this.asignoChofer()==null || !this.dispVehiculo(p)) {
    			try
    			{
    				System.out.println("El cliente" + c.getNombreReal() + "tiene que esperar");
    				wait();
    			} catch (InterruptedException e)
    			{
    				
    				e.printStackTrace();
    			}
    		}
    		setChanged();
    		notifyObservers("se acepta el viaje de " + c.getNombreReal());
    		System.out.println("se acepta el viaje de " + c.getNombreReal());
    		if (c.getNombreReal().equals("Cliente Tres"))
    			Controlador.infoCliente("se acepta el viaje de " + c.getNombreReal());
    		this.crearViajeSinVehiculo(p);
    		notifyAll();
    		
    	}

    


		public synchronized void pagaviaje(Cliente c) {
    	while ( this.viajesSinPagar.isEmpty() || this.EstaMiViaje(c)<0) {
    		try {
    			wait();
    		}
    		catch (InterruptedException e) {
    			
    		}
    	}
    	setChanged();
		notifyObservers("Se paga al viaje de " + c.getNombreReal());
    	System.out.println("Se paga al viaje de " + c.getNombreReal());
    	if (c.getNombreReal().equals("Cliente Tres"))
			Controlador.infoCliente("Se paga al viaje de " + c.getNombreReal());
    	this.viajesPagados.add(this.viajesSinPagar.get(EstaMiViaje(c)));
    	this.viajesSinPagar.remove(EstaMiViaje(c));
    	notifyAll();
    	}
        
		public synchronized void asignaVehiculo() {
    		while (this.viajesSinVehiculo.isEmpty() || this.asignoVehiculo(viajesSinVehiculo.getFirst())==null) {
    			try {
                            //    System.out.println("estan esperando un vehiculo");
                                wait();
    			}
    			catch (InterruptedException e)
    			{
				e.printStackTrace();
    			}
    		}
    		Vehiculo v=this.asignoVehiculo(viajesSinVehiculo.getFirst());     //asignoVehiculo devuelve el vehiculo ideal para p
    		this.crearViajeConVehiculo(this.viajesSinVehiculo.getFirst(), v);
    		this.viajesSinVehiculo.remove(0);
    		v.setDisponible(false);
    		setChanged();
    		notifyObservers("Se asigna el vehiculo" + v.getNroPatente());
    		System.out.println("Se asigna el vehiculo" + v.getNroPatente());
    		notifyAll();
    		
    	}
    	
    
		public synchronized void asignaChofer() throws NoHayChoferDisponibleException {   //toma un viaje de la lista
    		while (viajesConVehiculo.isEmpty() || this.asignoChofer()==null) {
    			try {
                                wait();
    			}
    			catch (InterruptedException e)
    			{
				e.printStackTrace();
    			}
    		}
    		Chofer c = this.asignoChofer();    
    		Pedido pedido = getPedidoLista();
    		Vehiculo vehiculo = getVehiculoLista();
    		TipoDeViaje viaje = FactoryViaje.getViaje(pedido, c, this.getDistancia(), vehiculo);
    		this.setViaje(viaje);
    		this.viajesSinPagar.add(viaje);
    		c.setDisponible(false);
    		this.viajesConVehiculo.remove(0);
    		setChanged();
    		notifyObservers("Se asigna el chofer" + c.getNombre());
    		System.out.println("Se asigna el chofer" + c.getNombre());
    		notifyAll();
    		
    	}
    	



		public synchronized void finalizaViaje(Chofer c) {
			//System.out.println("Estoy entrando a finaliza viaje");
    		while ( this.viajesPagados.isEmpty() || this.EstaMiViajePagado(c)<0) {
        		try {
        			wait();
        		}
        		catch (InterruptedException e) {
        			
        		}
        	}
    		setChanged();
    		notifyObservers("El Chofer " + c.getNombre() + "Finaliza el viaje");
        	System.out.println("El Chofer " + c.getNombre() + "Finaliza el viaje");
        	this.viajesPagados.get(EstaMiViajePagado(c)).getChofer().setDisponible(true);
        	this.viajesPagados.get(EstaMiViajePagado(c)).getVehiculo().setDisponible(true);
        	this.viajesPagados.remove(EstaMiViajePagado(c));
        	
        	notifyAll();
        }
        
        
  


		@Override
		public String toString() {
			return "Empresa [clientes=" + clientes + ", choferes=" + choferes + ", viajes=" + viajes + ", vehiculos=" + vehiculos + "]";
		}
 
}
