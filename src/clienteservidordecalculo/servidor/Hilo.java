/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidordecalculo.servidor;

import java.util.Arrays;
import java.util.logging.Level;

/**
 *
 * @author davidvalenzuela
 */
public class Hilo extends Thread    {
    
    private int respuesta;
    private String ipRecibida = null;
    private int[] array;
    
    public Hilo (String ip, int[] arreglo){
    this.ipRecibida=ip;
    this.array= arreglo;   
    }
    
    @Override
    public void run(){
         Cliente Escucha =  new Cliente();
         respuesta = Escucha.main(array,ipRecibida);
         System.out.println("respuesta "+ipRecibida+" es:"+respuesta);
    }
    
    public int getSum(){
    return respuesta;
    }
    
}
