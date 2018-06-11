package SocketProg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Server is Starting");
            DatagramSocket socket=new DatagramSocket(7500);
            boolean serverActive=true;
            byte[] buffer=new byte[256];

            DatagramPacket incomePacket=new DatagramPacket(buffer,buffer.length);
            socket.receive(incomePacket);
            InetAddress clientAddress=incomePacket.getAddress();
            int clientPrt=incomePacket.getPort();
            String message=new String(buffer,0,incomePacket.getLength());
            System.out.println("Server Received: "+message);

            String reply=message+"is sent to server";
            byte[] replybytes=reply.getBytes();
            DatagramPacket replyPacket=new DatagramPacket(replybytes, replybytes.length,clientAddress,clientPrt);
            socket.send(replyPacket);
            socket.close();

        }catch (SocketException ex){
            ex.printStackTrace();
        }
    }

}
