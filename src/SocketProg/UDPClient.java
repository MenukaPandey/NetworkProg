package SocketProg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) throws IOException{
        try{
            System.out.println("The client is starting");
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Enter Your message");
            Scanner input=new Scanner(System.in);
            String requestMessage=input.nextLine();

            byte[] requestbyte=requestMessage.getBytes();
            InetAddress serverAddress=InetAddress.getByName("127.0.0.1");
            DatagramPacket requestPacket=new DatagramPacket(requestbyte,requestbyte.length,serverAddress,7500);

            socket.send(requestPacket);
            byte[] reponsebuffer=new byte[256];
            DatagramPacket responsePacket=new DatagramPacket(reponsebuffer,reponsebuffer.length);

            socket.receive(responsePacket);
            String responsemessage= new String(reponsebuffer,0,responsePacket.getLength());

            System.out.println("Server Response"+responsemessage);
            socket.close();



        }catch (SocketException ex){
            ex.printStackTrace();
        }
    }
}
