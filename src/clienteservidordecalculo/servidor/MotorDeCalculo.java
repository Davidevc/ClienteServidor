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

    public int  Multiplicador(int a, int b) {
        return a*b;
    }

    public int Sumar150( int[] numeros) throws InterruptedException{
        int resultado = 0;
        if (numeros.length != 0) {
            for (int i = 0; i < numeros.length; i++) {
            resultado = resultado + numeros[i];
            TimeUnit.SECONDS.sleep(1);
            }
        }
        
        return resultado;
    }
}
