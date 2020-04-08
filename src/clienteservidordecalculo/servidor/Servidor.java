package clienteservidordecalculo.servidor;

import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    Logger log = Logger.getLogger("Log.");

    public String conexion() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int[] peticion = null;
        int respuesta = 0;

        try {
            System.out.println("Escuchando por el puerto 8000");
            serverSocket = new ServerSocket(8000, 300);
        } catch (IOException e) {
            System.out.println("java.io.IOException generada");
            e.printStackTrace();
        }

        System.out.println("Esperando a que los clientes se conecten...");
        while (true) {
            try {
                //SE CONECTA UN CLIENTE
                socket = serverSocket.accept();
                System.out.println("Se conecto un cliente: " + socket.getInetAddress().getHostName());
                
                //RECIBE EL OBJETO
                ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());
                try {
                    peticion = (int[]) dis.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("El mensaje que me envio el cliente es: " + Arrays.toString(peticion));
                
                //ENVIO DE INFORMACION POR EL SOCKET DEFINIDO 
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                
                MotorDeCalculo motor = new MotorDeCalculo();
                try {
                    respuesta = motor.Sumar150(peticion);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("El mensaje que le envio al cliente es: " + respuesta);
                dos.write(respuesta);

                dos.close();
                dis.close();
                socket = null;
            } catch (IOException e) {
                System.out.println("java.io.IOException generada");
                e.printStackTrace();
            }
        }

    }
}
