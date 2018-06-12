package UDPProg;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SingleChatClient {
    public static void main(String[] args) throws IOException{
        Socket cs=new Socket("192.168.10.10",225);
        Scanner ins=new Scanner(cs.getInputStream());
        PrintWriter outs=new PrintWriter(cs.getOutputStream(),true);
        Scanner ink=new Scanner(System.in);
        String rmsg,smsg;

        do {
            rmsg=ins.nextLine();
            System.out.println("\tSarbagya: "+rmsg);
            System.out.print("Menuka: ");
            smsg=ink.nextLine();
            outs.println(smsg);
        }while (rmsg.equals("buy")!=true);
        ins.close();
        outs.close();
        cs.close();
    }
}
