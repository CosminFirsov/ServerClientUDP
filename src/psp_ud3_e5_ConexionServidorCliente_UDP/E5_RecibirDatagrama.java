/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ud3_e5_ConexionServidorCliente_UDP;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author DAM203
 */
public class E5_RecibirDatagrama {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        byte[] bufer = new byte[1024];
        
        DatagramSocket socket = new DatagramSocket(12345, InetAddress.getByName("localhost"));
        
        System.out.println("Esperando Datagrama.....");
        DatagramPacket recibido = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibido);
        
        int byteRec = recibido.getLength();
        String paquet = new String(recibido.getData());
        
        System.out.println("Numero de Bytes recibidos: " + byteRec);
        System.out.println("Contenido del paquete: " + paquet.trim());
        System.out.println("Puerto origen del pauqete: " + recibido.getPort());
        System.out.println("IP de Origen : " + recibido.getAddress());
        System.out.println("Puerto destino del mensaje: " + socket.getLocalPort());

        socket.close();
    }
}
