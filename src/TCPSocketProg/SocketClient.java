package TCPSocketProg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws Exception{
        SocketClient client=new SocketClient();
        client.run();


    }
    public void run() throws Exception{
        Socket socket=new Socket("localhost",444);
        PrintStream PS=new PrintStream(socket.getOutputStream());
        PS.println("Hello to Server");

        InputStreamReader IR=new InputStreamReader(socket.getInputStream());

        BufferedReader BR=new BufferedReader(IR);
        String message=BR.readLine();
        System.out.println(message);
    }

}
