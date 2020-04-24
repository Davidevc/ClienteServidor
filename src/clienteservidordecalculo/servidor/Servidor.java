package clienteservidordecalculo.servidor;

import java.net.*;
import java.io.*;
import java.time.Clock;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    Logger log = Logger.getLogger("Log.");

    public String conexion() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        String peticion = null;
        String respuesta = null;
        Clock clock = Clock.systemUTC();

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
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                peticion = dis.readUTF();
                System.out.println("El mensaje que me envio el cliente es: " + peticion);
                
                //ENVIO DE INFORMACION POR EL SOCKET DEFINIDO 
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                System.out.println("La hora y fecha son :: " + clock.instant());
                respuesta = clock.instant().toString();
                
                System.out.println("El mensaje que le envio al cliente es: " + respuesta);
                dos.writeUTF(respuesta);

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
