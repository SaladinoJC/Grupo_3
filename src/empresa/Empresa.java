package empresa;

import java.util.ArrayList;

import choferes.Chofer;
import choferes.Contratado;
import choferes.Temporario;
import vehiculos.Vehiculo;

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
        
        //codigo vehiculos
        
        public Vehiculo getVehiculo(int index)
        {
            return vehiculos.get(index);
        }
        
       private void setVehiculo(Vehiculo vehiculo)
        {
            vehiculos.add(vehiculo);
        }
        
        public void ListarVehiculos()
        {
            int i;
            Vehiculo aux;
            for(i=0;i<vehiculos.size();i++)
            {
                aux=getVehiculo(i);
                aux.toString();
            }
        }
        //este metodo debe saltar una exepcion
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
        
        public Cliente getCliente(int index)
        {
            return clientes.get(index);
        }
        private void setCliente(Cliente cliente)
        {
            clientes.add(cliente);
        }
        public void ListarClientes()
        {
            int i;
            Cliente aux;
            for(i=0;i<clientes.size();i++)
            {
                aux=getCliente(i);
                aux.toString();
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
                aux.toString();
            }
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
