package UDPProg;

import java.io.InputStream;
import java.net.URL;

public class URLConnection {
    public static void main(String[] args){
        try{
            URL url=new URL("http://www.tutorialspoint.com:80/java/java_networking.htm");
            java.net.URLConnection urlcon=url.openConnection();
            InputStream stream=urlcon.getInputStream();
            int i;
            while ((i=stream.read())!=-1){
                System.out.print((char)i);
            }

        }catch (Exception ex){
            System.err.println(ex);
        }
    }
}
