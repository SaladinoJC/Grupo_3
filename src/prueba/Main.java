package prueba;

import empresa.Sistema;
import empresa.TipoDeViaje;
import empresa.Viaje;
import empresa.excepciones.ClienteExistenteException;
import empresa.excepciones.DateInvalidException;
import empresa.excepciones.ZoneInvalidException;
import empresa.excepciones.LuggageInvalidException;
import empresa.excepciones.NoHayChoferDisponibleException;
import empresa.excepciones.NoHayVehiculoDisponibleException;
import empresa.FactoryViaje;
import vehiculos.FactoryVehiculo;
import vehiculos.Vehiculo;
import vehiculos.exepciones.NoSePuedeCrearVehiculoException;
import vehiculos.exepciones.VehiculoExistenteException;

import java.time.LocalDate;
import java.time.LocalTime;

import choferes.Chofer;
import empresa.Administrador;
import empresa.Empresa;
import empresa.Pedido;
import empresa.Cliente;
import choferes.Contratado;
import choferes.Empleado;
import choferes.Permanente;
import choferes.Temporario;
import choferes.exepciones.DNImalingresadoExeption;
import choferes.exepciones.FechaMalIngresadaExeption;
import choferes.exepciones.PorcentajeExeption;
import choferes.exepciones.SueldoBasicoIncorrectoExeption;
import choferes.exepciones.valorPositivoExeption;

public class Main {
    public static void main(String[] args)  {
       	//crear una nueva instancia de Administrador (si es necesario)
        Administrador adm = new Administrador("nombre", "admin", "admin");
        LocalDate fechaEjemplo1 = LocalDate.of(2024, 5, 1);
        LocalDate fechaEjemplo2 = LocalDate.of(2022, 4, 3);
        LocalDate fechaEjemplo3 = LocalDate.of(2004, 12, 12);
        LocalDate fechaEjemplo4 = LocalDate.of(2001, 11, 8);
        LocalTime timeEjemplo1 = LocalTime.of(8,45);
        LocalTime timeEjemplo2 = LocalTime.of(10,15);
        LocalTime timeEjemplo3 = LocalTime.of(4,33);
        LocalTime timeEjemplo4 = LocalTime.of(11,20);
        // Se crea una nueva instancia de Sistema
        Sistema s = new Sistema(adm);
        // se instancian los factorys que seran usados despues
        FactoryViaje factoryviaje = new FactoryViaje();
        FactoryVehiculo factoryvehiculo = new FactoryVehiculo();
        
        // Crear choferes
        try {             //CHOFER CON DNI MAL CREADO
	        Permanente ch1 = new Permanente(20, 30, 1, fechaEjemplo1, 0.1, "Roberto", "42.231.365", 300000);
	        s.insertarChofer(ch1);
	        }
	        catch(DNImalingresadoExeption e) {
	        	System.out.println("No se pudo crear el chofer, DNI MAL INGRESADO");
	        }
	        catch(FechaMalIngresadaExeption e) {
	        	System.out.println("No se pudo crear el chofer, FECHA MAL INGRESADA");
	        }
	        catch(PorcentajeExeption e) {
	        	System.out.println("No se pudo crear el chofer, PORCENTAJE ERRONEO");
	        }
	        catch(SueldoBasicoIncorrectoExeption e) {
	        	System.out.println("No se pudo crear el chofer, SUELDO BASICO ERRONEO");
	        }
	        catch(valorPositivoExeption e) {
	        	System.out.println("No se pudo crear el chofer, VALOR INVALIDO, DEBE SER ENTERO y MAYOR a 0");
	        }
        try {
	        Permanente ch1 = new Permanente(20, 30, 1, fechaEjemplo1, 0.1, "Roberto", "42231365", 300000);
	        s.insertarChofer(ch1);
	        }
	        catch(DNImalingresadoExeption e) {
	        	System.out.println("No se pudo crear el chofer, DNI MAL INGRESADO");
	        }
	        catch(FechaMalIngresadaExeption e) {
	        	System.out.println("No se pudo crear el chofer, FECHA MAL INGRESADA");
	        }
	        catch(PorcentajeExeption e) {
	        	System.out.println("No se pudo crear el chofer, PORCENTAJE ERRONEO");
	        }
	        catch(SueldoBasicoIncorrectoExeption e) {
	        	System.out.println("No se pudo crear el chofer, SUELDO BASICO ERRONEO");
	        }
	        catch(valorPositivoExeption e) {
	        	System.out.println("No se pudo crear el chofer, VALOR INVALIDO, DEBE SER ENTERO y MAYOR a 0");
	        }
        try {
            Contratado ch2 = new Contratado(1500, "Jimeno", "42231366");
            s.insertarChofer(ch2);
            }
            catch(DNImalingresadoExeption e) {
            	System.out.println("No se pudo crear el chofer, DNI MAL INGRESADO");
            }

            catch(PorcentajeExeption e) {
            	System.out.println("No se pudo crear el chofer, PORCENTAJE ERRONEO");
            }
            catch(SueldoBasicoIncorrectoExeption e) {
            	System.out.println("No se pudo crear el chofer, SUELDO BASICO ERRONEO");
            }

        try {
        	Temporario ch3 = new Temporario(10, 0.2, "Rumiante", "42231367", 200000);
            s.insertarChofer(ch3);
            }
            catch(DNImalingresadoExeption e) {
            	System.out.println("No se pudo crear el chofer, DNI MAL INGRESADO");
            }

            catch(PorcentajeExeption e) {
            	System.out.println("No se pudo crear el chofer, PORCENTAJE ERRONEO");
            }
            catch(SueldoBasicoIncorrectoExeption e) {
            	System.out.println("No se pudo crear el chofer, SUELDO BASICO ERRONEO");
            }

        try {
        	Contratado ch4 = new Contratado(10,"Sullivan", "42231368");
            s.insertarChofer(ch4);
            }
            catch(DNImalingresadoExeption e) {
            	System.out.println("No se pudo crear el chofer, DNI MAL INGRESADO");
            }
            catch(PorcentajeExeption e) {
            	System.out.println("No se pudo crear el chofer, PORCENTAJE ERRONEO");
            }
            catch(SueldoBasicoIncorrectoExeption e) {
            	System.out.println("No se pudo crear el chofer, SUELDO BASICO ERRONEO");
            }


              
        
        //Crear clientes
        Cliente c1 = new Cliente("cliente1", "pass1", "Cliente Uno");
        Cliente c2 = new Cliente("cliente2", "pass2", "Cliente Dos"); 
        Cliente c3 = new Cliente("cliente3", "pass3", "Cliente Tres"); 
        Cliente c4 = new Cliente("cliente4", "pass4", "Cliente Cuatro");
        
        try {
        	s.insertarCliente(c1);
		} catch (ClienteExistenteException e) {
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
        	s.insertarCliente(c2);
		} catch (ClienteExistenteException e) {
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
        	s.insertarCliente(c3);
		} catch (ClienteExistenteException e) {
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
        	s.insertarCliente(c4);
		} catch (ClienteExistenteException e) {
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        try {
        	s.insertarCliente(c4);
		} catch (ClienteExistenteException e) {
			System.out.println("No se pudo insertar el cliente  " + e.cliente+" ya que ya esta en el arraylist ");
		}
        

        
        //Crear vehiculos
        
        try {
            Vehiculo v1 = factoryvehiculo.getVehiculo("111AAA", 4, true, true);
            s.insertarVehiculo(v1);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
         	System.out.println("No se pudo insertar el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}    
        try {
        	Vehiculo v2 = factoryvehiculo.getVehiculo("222BBB", 4, true, true);
        	s.insertarVehiculo(v2);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
         	System.out.println("No se pudo insertar el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {
        	Vehiculo v3 = factoryvehiculo.getVehiculo("333CCC", 10, false, true);
        	s.insertarVehiculo(v3);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
         	System.out.println("No se pudo insertar el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try { 
        	Vehiculo v4 = factoryvehiculo.getVehiculo("444DDD", 10, false, true);
        	s.insertarVehiculo(v4);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
         	System.out.println("No se pudo insertar el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {
        	Vehiculo v5 = factoryvehiculo.getVehiculo("555EEE", 1, false, false);
        	s.insertarVehiculo(v5);
        	s.insertarVehiculo(v5);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
         	System.out.println("No se pudo insertar el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
        try {  //INTENTO ERRONEO DE CREAR UN VEHICULO DE 3 PASAJEROS
        	Vehiculo v6 = factoryvehiculo.getVehiculo("666FFF", 3, false, true);
        	s.insertarVehiculo(v6);
        } catch (NoSePuedeCrearVehiculoException e) {
            // Manejo de la excepción si no se puede crear el vehículo
            System.out.println("No se pudo crear el vehículo: " + e.getNroPatente());
        } catch (VehiculoExistenteException e) {
        	System.out.println("No se pudo insertar el vehículo: " + e.vehiculo+" ya que ya esta en el arraylist");
		}  
       
       //Crear Pedidos
        //1-   Sin asfaltar, sin mascota, sin baul, 1 pasajero, cliente 1, deberia asignar una moto
        try {
        	Pedido p1 = new Pedido(fechaEjemplo1, timeEjemplo1, "Sin asfaltar", false, "Manual", 1, c1);
        	s.dispVehiculo(p1);
        	//System.out.println("VEHICULO ASIGNADO 1:"+s.asignoVehiculo(p1));
        	TipoDeViaje v1 = factoryviaje.getViaje(p1, s.asignoChofer(), s.getDistancia(), s.asignoVehiculo(p1));
            //System.out.println(" ");
            //System.out.println(" ");
        	s.setViaje(v1);
        	//System.out.println("el primer viaje es: "+s.GUILLEsa.viajes.get(0));
        	s.mueveChofer();
        }
        catch(NoHayVehiculoDisponibleException e) {
        	System.out.println(e.mensaje);
        }
        catch(DateInvalidException e1){
        	LocalDate date = e1.getDate();
        	System.out.println("Error, el dato: "+ date + " es invalido");
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        	System.out.println("Error, el dato: "+ zone + " es invalido");
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        	System.out.println("Error, el dato: "+ luggage + " es invalido");
        } catch (NoHayChoferDisponibleException e) {
			System.out.println(e.mensaje);
		}
        //2  Peligrosa, sin mascota, con baul, 12 pasajeros, cliente 2 . Deberia lanzar excepcion, no hay disponible
        try {
        	Pedido p2 = new Pedido(fechaEjemplo2, timeEjemplo2, "Peligrosa", false, "Baul", 12, c2);
        	s.dispVehiculo(p2);
        	//System.out.println("el vehiculo a asignar es: "+s.asignoVehiculo(p2));
        	TipoDeViaje v2 = factoryviaje.getViaje(p2, s.asignoChofer(), s.getDistancia(), s.asignoVehiculo(p2));
           // System.out.println(" ");
           // System.out.println(" ");
        	s.setViaje(v2);
        	s.mueveChofer();
        }
        catch(NoHayVehiculoDisponibleException e) {
        	System.out.println(e.mensaje);
        }
        catch(DateInvalidException e1){
        	LocalDate date = e1.getDate();
        	System.out.println("Error, el dato: "+ date + " es invalido");
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        	System.out.println("Error, el dato: "+ zone + " es invalido");
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        	System.out.println("Error, el dato: "+ luggage + " es invalido");
        } catch (NoHayChoferDisponibleException e) {
			System.out.println(e.mensaje);
		}
        //3 Peligrosa, sin mascota, con baul, 8 pasajeros, cliente 3. Deberia asignar combi
        try {
        	Pedido p3 = new Pedido(fechaEjemplo3, timeEjemplo3, "Peligrosa", false, "Baul", 8, c3);
        	s.dispVehiculo(p3);
        	//System.out.println("El vehiculo asignado es: "+s.asignoVehiculo(p3));
        	TipoDeViaje v3 = factoryviaje.getViaje(p3, s.asignoChofer(), s.getDistancia(), s.asignoVehiculo(p3));
           // System.out.println(" ");
           // System.out.println(" ");
          //  System.out.println("v3 es: "+v3);
        	s.setViaje(v3);
        	s.mueveChofer();
        	//System.out.println("el 2do viaje es: "+s.GUILLEsa.viajes.get(1));
        }
        catch(NoHayVehiculoDisponibleException e) {
        	System.out.println(e.mensaje);
        }
        catch(DateInvalidException e1){
        	LocalDate date = e1.getDate();
        	System.out.println("Error, el dato: "+ date + " es invalido");
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        	System.out.println("Error, el dato: "+ zone + " es invalido");
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        	System.out.println("Error, el dato: "+ luggage + " es invalido");
        } catch (NoHayChoferDisponibleException e) {
			System.out.println(e.mensaje);
		}
        // 4 Estandar, Con mascota, Con Baul, 4 pasajeros, cliente 4
        try {
        	Pedido p4 = new Pedido(fechaEjemplo4, timeEjemplo4, "Estandar", true, "Baul", 4, c4);
        	s.dispVehiculo(p4);
        	TipoDeViaje v4 = factoryviaje.getViaje(p4, s.asignoChofer(), s.getDistancia(), s.asignoVehiculo(p4));
          //  System.out.println(" ");
           // System.out.println(" ");
        	s.setViaje(v4);
        	s.mueveChofer();
        }
        catch(NoHayVehiculoDisponibleException e) {
        	System.out.println(e.mensaje);
        }
        catch(DateInvalidException e1){
        	LocalDate date = e1.getDate();
        	System.out.println("Error, el dato: "+ date + " es invalido");
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        	System.out.println("Error, el dato: "+ zone + " es invalido");
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        	System.out.println("Error, el dato: "+ luggage + " es invalido");
        } catch (NoHayChoferDisponibleException e) {
			System.out.println(e.mensaje);
		}
        //5 Peligrosa, con mascota, sin baul, 3 pasajeros, c1
        try {
        	Pedido p5 = new Pedido(fechaEjemplo2, timeEjemplo2, "Peligrosa", true, "Manual", 3, c1);
        	s.dispVehiculo(p5);
        	TipoDeViaje v5 = factoryviaje.getViaje(p5, s.asignoChofer(), s.getDistancia(), s.asignoVehiculo(p5));
           // System.out.println(" ");
           // System.out.println(" ");
        	s.setViaje(v5);
        	s.mueveChofer();
        }
        catch(NoHayVehiculoDisponibleException e) {
        	System.out.println(e.mensaje);
        }
        catch(DateInvalidException e1){
        	LocalDate date = e1.getDate();
        	System.out.println("Error, el dato: "+ date + " es invalido");
        }
        catch(ZoneInvalidException e2){
        	String zone = e2.getZone();
        	System.out.println("Error, el dato: "+ zone + " es invalido");
        }
        catch(LuggageInvalidException e3){
        	String luggage = e3.getLuggage();
        	System.out.println("Error, el dato: "+ luggage + " es invalido");
        } catch (NoHayChoferDisponibleException e) {
			System.out.println(e.mensaje);
		}
        
        
        
        
        
        
        
        
        System.out.println(" ");
        System.out.println(" ");
        s.calculoDePuntaje();
        System.out.println("             Listado de Choferes");
        try {
			System.out.println(s.ListarChoferes());
		} catch (SueldoBasicoIncorrectoExeption e) {
			System.out.println("ERROR, SUELDO BASICO ERRONEO");
		}
        System.out.println("             Listado de Vehiculos");
        System.out.println(s.ListarVehiculos());
        System.out.println("             Listado de Clientes");
        System.out.println(s.ListarClientes());
        System.out.println("             Listado de Viajes");
        System.out.println(s.ListarViajes());
        try {
			System.out.println("Total a pagar a los choferes= "+s.TotalPagar());
		} catch (SueldoBasicoIncorrectoExeption e) {
			System.out.println("ERROR, SUELDO BASICO ERRONEO");
		}



    }
}