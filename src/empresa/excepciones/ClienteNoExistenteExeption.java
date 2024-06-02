/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package empresa.excepciones;

import empresa.Cliente;

/**
 *
 * @author manso
 */
public class ClienteNoExistenteExeption extends Exception{
    private Cliente cliente;
 
    public ClienteNoExistenteExeption(Cliente cliante) {
        this.cliente=cliante;
        
    }

}
