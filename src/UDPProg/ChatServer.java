package UDPProg;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(400);
        Socket cs=ss.accept();

        Scanner ins=new Scanner(cs.getInputStream());
        PrintWriter outs=new PrintWriter(cs.getOutputStream(),true);
        Scanner ink =new Scanner(System.in);
        String rmsg,smsg;

        do {
            System.out.print("Server: ");
            smsg=ink.nextLine();
            outs.println(smsg);
            rmsg=ins.nextLine();
            System.out.println("\t Client: "+rmsg);
            System.out.println();

        }while (!rmsg.equals("buy"));
        outs.close();
        ins.close();
        ink.close();
        ss.close();
        cs.close();

    }
}
