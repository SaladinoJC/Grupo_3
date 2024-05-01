package empresa;

import java.util.ArrayList;

import choferes.Chofer;
import choferes.Contratado;
import choferes.Temporario;
import java.time.LocalDate;
import vehiculos.Vehiculo;

public class Empresa {
	private static Empresa referencia;
	private ArrayList<Cliente>clientes;
	private ArrayList<Chofer>choferes;
	private ArrayList<TipoDeViaje>viajes;
        private ArrayList<Vehiculo>vehiculos;
	
	
	
	private Empresa() {
		this.choferes=new ArrayList<Chofer>();
		this.clientes=new ArrayList<Cliente>();
		this.viajes=new ArrayList<TipoDeViaje>();
                this.vehiculos=new ArrayList<Vehiculo>();
		
	}
	
        /**
         * patron singleton
         * @return 
         */
		public static Empresa getReferencia()
        {
			if(referencia == null){
				referencia=new Empresa();
			}
			return referencia;
        }
        
        /**
         * este metodo inserta un chofer a la lista de choferes si ya existe salta una exepcion
         * @param chofer 
         */
        public void insertarChofer(Chofer chofer)
        {
            if(!buscarChofer(chofer)) 
                setChofer(chofer);
            else
            {
                //una exepcion
            }   
        }
        
        /**
         * 
         * @param chofer
         * @return true si el chofer existe,caso contrario false
         */
        public boolean buscarChofer(Chofer chofer)
        {
            int i=0;
            Chofer aux=getChofer(i);
            while(i<choferes.size() && !aux.equals(chofer))
            {
                i++;
                aux=getChofer(i);
            }
            return i<choferes.size();
        }
        
        /**
         * 
         * @param chofer
         * @return chofer si existe, null si no lo encuantre
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
         * 
         * @param index
         * @return devuelve un chofer del arraylist
         */
        public Chofer getChofer(int index)
        {
            return choferes.get(index);
        }
        /**
         * ingresa un chofer al arraylist
         * @param chofer 
         */
        private void setChofer(Chofer chofer)
        {
            choferes.add(chofer);
        }
        
        /**
         * 
         * @return devuelve un strings con los datos de todos los choferes
         */
        public  String ListarChoferes()
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
                cadena=cadena.concat("\n\n");
            }
            return cadena;
        }
        
        /**
         * recibe un chofer, una fecha de inicio y una fecha de fin
         * @param chofer
         * @param inicio
         * @param fin
         * @return un cadena con los viajes que realizo durante la fecha de inicio y fin
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
                  //exepcion el chofer no existe
                else
                    //otra exepcion por que la fecha inicio no es menor fin
            return cadena;
        }
        //codigo vehiculos
        /**
         * 
         * @param index
         * @return devuelve un vehiculo de la lista 
         */
        public Vehiculo getVehiculo(int index)
        {
            return vehiculos.get(index);
        }
        /**
         * inserta un vehiculo en la lista
         * @param vehiculo 
         */
        private void setVehiculo(Vehiculo vehiculo)
        {
            vehiculos.add(vehiculo);
        }
       
        /**
         * 
         * @return devuelve una cadena con todos los vehiculos
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
                cadena=cadena.concat("\n\n");
            }
            return cadena;
        }
        
        /**
         * busca un vehiculo
         * @param vehiculo
         * @return true si existe, false si no existe
         */
        public boolean buscarVehiculo(Vehiculo vehiculo)
        {
            int i=0;
            Vehiculo aux=getVehiculo(i);
            while(i<vehiculos.size() && !aux.equals(vehiculo))
            {
                i++;
                aux=getVehiculo(i);
            }
            return i<vehiculos.size();
        }
	
         /**
          * 
          * @param vehiculo
          * @return un vehiculo en particular, si no lo encuentra retorna null
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
         * inserta un vehiculo
         * @param vehiculo 
         */ 
        public void insertarVehiculo(Vehiculo vehiculo)
        {
            if(!buscarVehiculo(vehiculo))
                setVehiculo(vehiculo);
            else
            {
                //aca va una exepcion
            }
        }
        
        //codigo de clientes
        /**
         * 
         * @param index
         * @return devuelve un cliente de la lista
         */
        public Cliente getCliente(int index)
        {
            return clientes.get(index);
        }
        
        //agrega un cliente
        /**
         * agrega un cliente a la lista de clientes
         * @param cliente 
         */
        private void setCliente(Cliente cliente)
        {
            clientes.add(cliente);
        }
        
        /**
         * 
         * @return devuelve una cadena con todos los clientes 
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
                cadena=cadena.concat("\n\n");
            }
            return cadena;
        }
        
        /**
         * busca un cliente
         * @param cliente
         * @return devuelve true si existe el cliente,false si no existe
         */
        public  boolean buscarCliente(Cliente cliente)
        {
            int i=0;
            Cliente aux=getCliente(i);
            while(i<clientes.size() && ! aux.equals(cliente))
            {
                i++;
                aux=getCliente(i);
            }
            return i<clientes.size();
        }
        
        /**
         * busca un cliente
         * @param cliente
         * @return devuelve el cliente si lo encuentra, null si no lo encuentra
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
         * recibe un cliente, una fecha de ingreso y una fecha de fin
         * @param cliente
         * @param inicio
         * @param fin
         * @return devuelve una cadena con todos los viajes q realizo de la fecha de ingreso y la de fin
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
                    //exepcion el cliente no existe
                else
                    //le fecha ingresadas. inicio no es menor a fin
             return cadena;
        }
        
        /**
         * inserta un cliente, si este no existe en la lista
         * @param cliente 
         */
        public void insertarCliente(Cliente cliente)
        {
            if(!buscarCliente(cliente))
                setCliente(cliente);
            else
            {
                //aca va una exepcion
            }
        }
        
        /**
         * 
         * @param index
         * @return devuelve un viaje
         */
        public TipoDeViaje getViaje(int index)
        {
            return viajes.get(index);
        }
        
        /**
         * inserta un viaje
         * @param viaje 
         */
        public void setViaje(TipoDeViaje viaje)
        {
            viajes.add(viaje);
        }
        /**
         * 
         * @return devuelve un vector con todos los viajes
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
                cadena=cadena.concat("\n\n");
            }
            return cadena;
        }
        //ordena la lista viajes por costos
        
       /**
        * ordena los viajes por costos en una lista clonada
        * @return devuelve una cadena con todos los viajes ordenamos de mayor a menor 
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
         * clona el arraylista y lo almacena en un vector
         * @return retorna la referencia a dicho vector
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
         * desde la clase empresa se setea el sueldo de los contratados,respecto la cantidad de viajes q realizo
         */
        public void setiarSueldoContratados()
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
                    contratado.setSueldoBasico(sueldo);
                }
            }
 
        }
        
        /**
         * seteo la cantidad de viajes que realizaron los temporarios
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
         * calcula y setea el puntaje de cada chofer
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
         * 
         * @return devuelve el total a pagar de la empresa en sueldos 
         */
        public double TotalPagar()
        {
            Chofer aux;
            int i;
            double total=0;
            setiarSueldoContratados();
            setiarCantidadViajesTemporarios();
            for(i=0;i<choferes.size();i++)
            {
               aux=getChofer(i);
               total+=aux.calcularSueldo();
            }
            return total;
        }
}
