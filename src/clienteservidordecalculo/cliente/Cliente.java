package clienteservidordecalculo.cliente;

import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Cliente {

    public String main(String sock) {

        Socket socket = null;
        String respuesta = null;
        String consulta= "¿Cual es la hora?";

        try {
            //System.out.println("Me conecto al puerto 8000 del servidor");
            socket = new Socket(sock, 8000);
           
            //System.out.println("Le envio mi peticion: " + b.toString(),c);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(sock);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            respuesta = dis.readUTF();
                  
            // System.out.println("El mensaje que me envio el servidor es: " + respuesta);
            dos.close();
            dis.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("java.io.IOException generada");
            e.printStackTrace();
        }
        return respuesta;
    }
}
