/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteservidordecalculo.cliente;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String respuesta = null;
        Cliente Escucha =  new Cliente();
        
        respuesta = Escucha.main("192.168.0.12");
        System.out.println("La hora correcta es :: " + respuesta);
        cambioHora();

    }
    
    
    public static void cambioHora(){
       String command = "date -u "+"0624124920";
 
        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


