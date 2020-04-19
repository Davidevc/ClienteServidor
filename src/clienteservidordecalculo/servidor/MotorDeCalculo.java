/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteservidordecalculo.servidor;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author 173751672
 */
public class MotorDeCalculo {


    public int sumarYParticionar ( int[] numeros)throws InterruptedException{
        int resultado = 0;
        int[] nuevoArray= new int[0];
        Cliente Escucha =  new Cliente();
        String servidorIp = null;
        int respuesta = 0;
        
        if (numeros.length == 150){
                nuevoArray = new int[100];
                for (int i = 100; i < 150; i++) {
                    resultado = resultado + numeros[i];
                    }
                for (int i = 0; i < 100; i++) {
                    nuevoArray[i] = numeros[i];
                }
            servidorIp = "192.168.0.12";
        }
        else if (numeros.length == 100) {
                nuevoArray = new int[50];
                for (int i = 50; i < 100; i++) {
                    resultado = resultado + numeros[i];
                    }
                for (int i = 0; i < 50; i++) {
                    nuevoArray[i] = numeros[i];
                }
            servidorIp = "192.168.0.12";
        }
        respuesta = Escucha.main(nuevoArray,servidorIp);
        resultado = +respuesta;
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
