/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteservidordecalculo.servidor;

import java.util.concurrent.TimeUnit;
import clienteservidordecalculo.servidor.Hilo;

/**
 *
 * @author 173751672
 */
public class MotorDeCalculo {


    public int sumarYParticionar ( int[] numeros)throws InterruptedException{
        int resultado = 0;
        int[] nuevoArray= new int[0];
        String servidorIp = null;
        int respuesta = 0;
        
                if (numeros.length == 150){
                        nuevoArray = new int[100];
                        for (int i = 0; i < 100; i++) {
                            nuevoArray[i] = numeros[i];
                        }
                        Hilo tarea1 = new Hilo("201.241.93.153", nuevoArray);
                        Thread hilo = new Thread(tarea1);
                        hilo.start();
                        
                        for (int i = 100; i < 150; i++) {
                            resultado = resultado + numeros[i];
                            }
                        hilo.join();
                        respuesta = tarea1.getSum();
                }
                else if (numeros.length == 100) {
                        nuevoArray = new int[50];
                        for (int i = 0; i < 50; i++) {
                            nuevoArray[i] = numeros[i];
                        }
                        Hilo tarea1 = new Hilo("200.73.236.129", nuevoArray);
                        Thread hilo = new Thread(tarea1);
                        hilo.start();
                        
                        
                        for (int i = 50; i < 100; i++) {
                            resultado = resultado + numeros[i];
                            }
                        hilo.join();
                        respuesta = tarea1.getSum();
                }
        System.out.println("respuesta del servidor " + servidorIp + " es: " + respuesta);
        resultado = resultado +respuesta;
        System.out.println("resultado de la suma y lo que llega es: " + resultado);
        return resultado;
    }
    
    
    public int Sumar( int[] numeros) throws InterruptedException{
        int resultado = 0;
        if (numeros.length != 0) {
            for (int i = 0; i < numeros.length; i++) {
            resultado = resultado + numeros[i];
            }
        }
        
        return resultado;
    }
}
