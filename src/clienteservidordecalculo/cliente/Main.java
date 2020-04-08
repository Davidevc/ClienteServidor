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
        
        Cliente Escucha =  new Cliente();
        int respuesta;
        
        Hilo tarea1 = new Hilo("186.21.30.134");
        Thread hilo = new Thread(tarea1);
        
        Hilo tarea2 = new Hilo("200.73.236.129");
        Thread hilo2 = new Thread(tarea2);
        
        Hilo tarea3 = new Hilo("201.241.93.153");
        Thread hilo3 = new Thread(tarea3);

       hilo.start();
       hilo2.start();
       hilo3.start();
       
       hilo.join();
       hilo2.join();
       hilo3.join();
       
       System.out.println("respuesta: " + tarea1.getSum());        
       System.out.println("respuesta2: "+ tarea2.getSum());      
       System.out.println("respuesta3: "+ tarea3.getSum());
       
       int array[]= {tarea1.getSum(),tarea2.getSum(),tarea3.getSum()};
       respuesta = Escucha.main(array,"186.21.30.134");
        System.out.println("respuesta total: "+ respuesta);

    }
}
