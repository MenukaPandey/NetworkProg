package TCPSocketProg;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws  Exception{
        SocketServer server=new SocketServer();
        server.run();

    }
    public void run() throws Exception{
        ServerSocket Serversocket=new ServerSocket(444);
        Socket socket=Serversocket.accept();
        InputStreamReader IR=new InputStreamReader(socket.getInputStream());

        BufferedReader BR=new BufferedReader(IR);
        String message=BR.readLine();
        System.out.println(message);

        if (message!=null){
            PrintStream PS=new PrintStream(socket.getOutputStream());
            PS.println("Message Received");
        }

    }
}
