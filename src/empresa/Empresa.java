package empresa;

import java.util.ArrayList;

import choferes.Chofer;
import choferes.Contratado;
import choferes.Temporario;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import empresa.excepciones.ClienteExistenteException;
import vehiculos.FactoryVehiculo;
import vehiculos.Vehiculo;
import vehiculos.exepciones.NoSePuedeCrearVehiculoException;
import vehiculos.exepciones.VehiculoExistenteException;

import java.time.LocalDate;
import vehiculos.Vehiculo;

/**
 * La clase Empresa representa todos los datos de la empresa.
 * Puede lanzar excepciones
 */

public class Empresa {
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
	
    /**
     * Constructor privado de la clase Empresa.
     * Se inicializan las listas de clientes, choferes, viajes y veh�culos.
     */
	public Empresa() {
		this.choferes=new ArrayList<Chofer>();
		this.clientes=new ArrayList<Cliente>();
		this.viajes=new ArrayList<TipoDeViaje>();
        this.vehiculos=new ArrayList<Vehiculo>();
	}
	
		/**
		 * M�todo para obtener la instancia �nica de la clase Empresa (patr�n singleton).
		 *
		 * @return La instancia �nica de la empresa.
		 */
		public static Empresa getReferencia()
        {
			if(referencia == null){
				referencia=new Empresa();
			}
			return referencia;
        }
        
	    /**
	     * Inserta un chofer en la lista de choferes de la empresa.
	     * Si el chofer ya existe, lanza una excepci�n.
	     *
	     * @param chofer El chofer a insertar.
	     * @throws 
	     */
        public void insertarChofer(Chofer chofer)
        {	if (choferes.isEmpty())
        	setChofer(chofer);
        	else
            if(!buscarChofer(chofer)) 
                setChofer(chofer);
            else
            {
                //una exepcion
            }   
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
         * @param index El �ndice del chofer.
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
                if(!buscarChofer(chofer))
                	System.out.println("robertiti");
                  //exepcion el chofer no existe
                else
                	System.out.println("roberto");
                    //otra exepcion por que la fecha inicio no es menor fin
            return cadena;
        }
        //codigo vehiculos
        
        /**
         * Devuelve un veh�culo de la lista seg�n su �ndice.
         * 
         * @param index El �ndice del veh�culo en la lista.
         * @return el veh�culo de la lista en la posici�n especificada. 
         */
        public Vehiculo getVehiculo(int index)
        {
            return vehiculos.get(index);
        }
        /**
         * Inserta un veh�culo en la lista de veh�culos.
         * 
         * @param vehiculo El veh�culo que se desea insertar. 
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
        

        
        
        
        //codigo de clientes
        
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
        public  boolean buscarCliente(Cliente cliente)
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
         * @return el cliente si lo encuentra, null si no lo encuentra.
         */
         public Cliente buscarXcliente (Cliente cliente)
        {
            Cliente aux;
            int i=0;
            aux=getCliente(i);
            while(i<clientes.size() && !aux.equals(cliente))
            {
                i++;
                aux=getCliente(i);
            }
            if(i<clientes.size())
                return aux;
            else
                return null;
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
        public String ListarViajesXcliente(Cliente cliente,LocalDate inicio,LocalDate fin)
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
                if(!buscarCliente(cliente))
                	System.out.println("roberto");
                    //exepcion el cliente no existe
                else
                	System.out.println("roberto");
                    //le fecha ingresadas. inicio no es menor a fin
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
            	// Lanza una excepci�n si el cliente ya existe
                throw new ClienteExistenteException(cliente);
            }
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
            for(i=1;i<viajes.size();i++)//odenamiento por insercion
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
            TipoDeViaje[] vector=new TipoDeViaje[viajes.size()];
            int i;
            for(i=0;i<viajes.size();i++)
                vector[i]=(TipoDeViaje)viajes.get(i).clone();
            return vector;
        }

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
                aux=getChofer(i);//voy cargando cada choffer
                cont=0;
                for(j=0;j<viajes.size();j++)//recorro la lista de viajes
                {
                    viaje=getViaje(j);
                    if(viaje.getChofer().equals(aux))//si el chofer realizo ese viaje aumento el contador en 1
                            cont++;
                }
                aux.setPuntaje(cont*5);//seteo puntaje del chofer
                if(max<cont)//si es el chofer con mas viajes realizados me lo guardo
                {
                    mayor=aux;
                    max=cont;
                }    
            }
            mayor.aumentarPuntaje(15);//aumento en 15 puntos al chofer q mas viajes realizo
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
        
        

		@Override
		public String toString() {
			return "Empresa [clientes=" + clientes + ", choferes=" + choferes + ", viajes=" + viajes + ", vehiculos="
					+ vehiculos + "]";
		}
        
        
}
