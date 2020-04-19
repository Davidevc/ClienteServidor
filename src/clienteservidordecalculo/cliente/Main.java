/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteservidordecalculo.cliente;

import clienteservidordecalculo.cliente.Hilo;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 173751680
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Logger log = Logger.getLogger("Log.");
    
    public static void main(String[] args) throws InterruptedException {
        
        int respuesta;
        int[] array = generarArreglo();
        
       Cliente Escucha =  new Cliente();
       
       respuesta = Escucha.main(array,"192.168.0.12");
       System.out.println("respuesta total: "+ respuesta);
    }
    
        private static int[] generarArreglo(){
            
        int[] resultado = new int[150];
        for (int i = 0; i < resultado.length; i++) {
            //int valorDado = (int) (Math.random()*10+1);
            resultado[i] = 1;//valorDado;
        }
        
        log.log(Level.INFO, "el arrelo generado es: "+ Arrays.toString(resultado));
        return resultado;
    }

}
