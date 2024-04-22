package empresa;

import java.util.ArrayList;

import choferes.Chofer;
import choferes.Contratado;
import choferes.Temporario;
import java.time.LocalDate;
import java.util.Collection;
import vehiculos.Vehiculo;
import java.util.Collections;

public class Empresa {
	private static Empresa referencia;
	private ArrayList<Cliente>clientes;
	private ArrayList<Chofer>choferes;
	private ArrayList<Viaje>viajes;
        private ArrayList<Vehiculo>vehiculos;
	
	
	
	private Empresa() {
		this.choferes=new ArrayList<Chofer>();
		this.clientes=new ArrayList<Cliente>();
		this.viajes=new ArrayList<Viaje>();
                this.vehiculos=new ArrayList<Vehiculo>();
		
	}
	
	public static Empresa getReferencia(){
		if(referencia == null)
		{
			referencia=new Empresa();
		}
		return referencia;
	}
        
        //codigo de choferes
        //metodo q debe largar una exepcion si el chofer ya existe
        public void insertarChofer(Chofer chofer)
        {
            if(!buscarChofer(chofer)) 
                setChofer(chofer);
            else
            {
                //una exepcion
            }   
        }
        //devuelve verdadero si el chofer ya existe
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
        //el metodo busca un chofer si no existe devuelve null
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
        //obtengo un chofer
        public Chofer getChofer(int index)
        {
            return choferes.get(index);
        }
        private void setChofer(Chofer chofer)
        {
            choferes.add(chofer);
        }
        //listar los choferes
        public  void ListarChoferes()
        {
            int i;
            Chofer aux;
            setiarCantidadViajesTemporarios();
            setiarSueldoContratados();
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i);
                aux.toString();
            }
        }
        //lista los viajes de un chofer en particular entre unas fechas como parametros
        //el metodo considera en la fecha fin>=inicio
        public void ListarViajesXchofer(Chofer chofer,LocalDate inicio,LocalDate fin)
        {
            LocalDate fecha;
            Viaje viaje;
            int i;
            if(buscarChofer(chofer) && inicio.isBefore(fin))//busca que el chofer exista
            {
                for(i=0;i<viajes.size();i++)
                {
                    viaje=getViaje(i);
                    fecha=viaje.getPedido().getFecha();
                    //pregunto que viajes realizo el chofer y si se encuentra entre la fechas de parametros
                    if(viaje.getChofer().equals(chofer) && (fecha.isAfter(inicio) && fecha.isBefore(fin) )) //pregunto q viajes realizo este cliente
                        System.out.println(viaje.toString());//muestros sus viajes
                }
            }
            else
                if(!buscarChofer(chofer))
                  //exepcion el chofer no existe
                else
                    //otra exepcion por que la fecha inicio no es menor fin
        }
        //codigo vehiculos
        
        public Vehiculo getVehiculo(int index)
        {
            return vehiculos.get(index);
        }
        
       private void setVehiculo(Vehiculo vehiculo)
        {
            vehiculos.add(vehiculo);
        }
        //lista todos los vehiculos 
        public void ListarVehiculos()
        {
            int i;
            Vehiculo aux;
            for(i=0;i<vehiculos.size();i++)
            {
                aux=getVehiculo(i);
                System.out.println(aux.toString());
            }
        }
        //busca un vehiculo devuelve verdadero si existe
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
        //busca un vehiculo en particular si no lo encuentra devuelve null
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
        //recupera un cliente
        public Cliente getCliente(int index)
        {
            return clientes.get(index);
        }
        //agrega un cliente
        private void setCliente(Cliente cliente)
        {
            clientes.add(cliente);
        }
        //lista todo los clientes que tenga la empresa
        public void ListarClientes()
        {
            int i;
            Cliente aux;
            for(i=0;i<clientes.size();i++)
            {
                aux=getCliente(i);
                System.out.println(aux.toString());
            }
        }
        //devuelve verdadero si el cliente existe
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
        //busca un cliente , si no lo encuentra devuelve null
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
         //lista los viajes de un cliente en particular y en un periodo de dias (con inicio y fin)
        public void ListarViajesXcliente(Cliente cliente,LocalDate inicio,LocalDate fin)
        {
            LocalDate fecha;
            Viaje viaje;
            int i;
            if(buscarCliente(cliente) && inicio.isBefore(fin))//busca que el cliente exista y que las fechas esten bien
            {
                for(i=0;i<viajes.size();i++)
                {
                    viaje=getViaje(i);
                    fecha=viaje.getPedido().getFecha();
                    //pregunto que viajes realizo el cliente y si se encuentra entre la fechas de parametros
                    if(viaje.getPedido().getCliente().equals(cliente) && (fecha.isAfter(inicio) && fecha.isBefore(fin) )) //pregunto q viajes realizo este cliente
                        System.out.println(viaje.toString());//muestros sus viajes
                }
            }
            else
                if(!buscarCliente(cliente))
                    //exepcion el cliente no existe
                else
                    //le fecha ingresadas. inicio no es menor a fin
        }
        //inserta un cliente siempre y cuando no exista ya en la lista
        public void insertarCliente(Cliente cliente)
        {
            if(!buscarCliente(cliente))
                setCliente(cliente);
            else
            {
                //aca va una exepcion
            }
        }
        
        //codigo viajes
        
        public Viaje getViaje(int index)
        {
            return viajes.get(index);
        }
        //viaje
        public void setViaje(Viaje viaje)
        {
            viajes.add(viaje);
        }
        public void ListarViajes()
        {
            int i;
            Viaje aux;
            for(i=0;i<viajes.size();i++)
            {
                aux=getViaje(i);
                System.out.println(aux.toString());
            }
        }
        public void ordenarViajesXCostos()
        {
            Collections.sort(viajes);//ordena la lista viajes por costos
            //el metodo compareTO esta implementado en la clase viaje
        }

        //codigo de contratados: setea el sueldo de los contratados como la cantidad de viajes q realizo
        public void setiarSueldoContratados()
        {
            Chofer aux;
            Contratado contratado;
            Viaje viaje;
            double sueldo;
            int i,j,cont;
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i);
                cont=0;sueldo=0;
                if(aux.getClass().getSimpleName() == "Contratado")//busco choferes contratados
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
        
        //seteo la cantidad de viajes de los temporarios
     
        //codigo de contratados: setea el sueldo de los contratados como la cantidad de viajes q realizo
        public void setiarCantidadViajesTemporarios()
        {
            Chofer aux;
            Temporario temporario;
            Viaje viaje;
            int i,j,cont;
            for(i=0;i<choferes.size();i++)
            {
                aux=getChofer(i);
                cont=0;
                if(aux.getClass().getSimpleName() == "Temporario")//busco choferes temporarios
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
        //metodo que calculo los puntajes de los choferes
        public void calculoDePuntaje()
        {
            Chofer aux,mayor = null;
            Viaje viaje;
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
                if(max<cont)//si es el chofer con mas viajes realizos me lo guardo
                {
                    mayor=aux;
                    max=cont;
                }    
            }
            mayor.aumentarPuntaje(15);//aumento en 15 puntos al chofer q mas viajes realizo
        }
        //total a pagar de la empresa
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
