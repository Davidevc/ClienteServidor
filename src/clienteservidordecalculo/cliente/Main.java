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
        
        String respuesta, respuesta2, respuesta3,respuesta4;
        
        Hilo tarea1 = new Hilo("192.168.0.12");
        Thread hilo = new Thread(tarea1);
        
//        Hilo tarea2 = new Hilo("200.73.236.129");
//        Thread hilo2 = new Thread(tarea2);
//        
//        Hilo tarea3 = new Hilo("201.241.93.153");
//        Thread hilo3 = new Thread(tarea3);
        // TODO code application logic here
        //Cliente Escucha =  new Cliente();
//        int[] array1 = generarArreglo();
//        int[] array2 = generarArreglo();
//        int[] array3 = generarArreglo();

       hilo.start();
//       hilo2.start();
//       hilo3.start();
       
       hilo.join();
       //System.out.println("respuesta: " + tarea1.getSum());
        
//       hilo2.join();
       //System.out.println("respuesta2: "+ tarea2.getSum());
//        
//       hilo3.join();
       //System.out.println("respuesta3: "+ tarea3.getSum());
           
//        respuesta = Escucha.main(array1,"186.21.30.134");
//        System.out.println("respuesta: "+respuesta);
//        
//        respuesta2 = Escucha.main(array2,"192.168.0.12");
//        System.out.println("respuesta2: "+respuesta2);
//        
//        respuesta3 = Escucha.main(array3,"200.73.236.129");
//        System.out.println("respuesta3: "+respuesta3);
        
    }
    
//        private static int[] generarArreglo(){
//            
//        int[] resultado = new int[150];
//        for (int i = 0; i < resultado.length; i++) {
//            int valorDado = (int) (Math.random()*10+1);
//            resultado[i] = valorDado;
//        }
//        
//        log.log(Level.INFO, "el arrelo generado es: "+ Arrays.toString(resultado));
//        return resultado;
//    }

}
