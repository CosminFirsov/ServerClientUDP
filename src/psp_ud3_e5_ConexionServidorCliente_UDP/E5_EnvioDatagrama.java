/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ud3_e5_ConexionServidorCliente_UDP;

import java.io.IOException;
import java.net.*;
import java.net.UnknownHostException;

/**
 *
 * @author DAM203
 */
public class E5_EnvioDatagrama {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        InetAddress destino = InetAddress.getByName("localhost");
        int port = 12345;
        byte[] mensaje = new byte[1024];
        
        String saludo = "Enviando Saludo !!";
        mensaje = saludo.getBytes();
        
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length,destino, port);
        DatagramSocket socket = new DatagramSocket(34567,InetAddress.getByName("localhost"));
        
        System.out.println("Enviando Datagram de longitud: " + mensaje.length);
        System.out.println("Host destino: "+ destino.getHostName());
        System.out.println("IP destino: "+ destino.getHostAddress());
        System.out.println("Puerto local del socket: " + socket.getLocalPort());
        System.out.println("Puerto al que envio: " + envio.getPort());
        
        socket.send(envio);
        socket.close();
        
    }
}
