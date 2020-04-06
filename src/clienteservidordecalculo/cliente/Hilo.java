/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidordecalculo.cliente;

import static clienteservidordecalculo.cliente.Main.log;
import java.util.Arrays;
import java.util.logging.Level;

/**
 *
 * @author davidvalenzuela
 */
public class Hilo extends Thread    {
    
    private int respuesta;
    private String ipRecibida = null;
    
    public Hilo (String ip){
    this.ipRecibida=ip;
    }
    
    @Override
    public void run(){
        Cliente Escucha =  new Cliente();
         int[] array1 = generarArreglo();
         String ip = this.getName();
         respuesta = Integer.parseInt(Escucha.main(array1,ipRecibida));
         System.out.println("respuesta "+ipRecibida+" es:"+respuesta);
    }
    
    private static int[] generarArreglo(){
            
        int[] resultado = new int[50];
        for (int i = 0; i < resultado.length; i++) {
            int valorDado = (int) (Math.random()*10+1);
            resultado[i] = valorDado;
        }
        
        log.log(Level.INFO, "el arrelo generado es: "+ Arrays.toString(resultado));
        return resultado;
    }
    
    public int getSum(){
    return respuesta;
    }
    
}
