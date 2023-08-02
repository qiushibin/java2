import java.io.*;
import java.net.*;

public class DailyAdviceServer{
    
    String    advice = "okokokoserver";
    public void go(){
        try{
            try (ServerSocket serversocket = new ServerSocket(4242)) {
                while(true){
                    Socket sock = serversocket.accept();
                    InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                    BufferedReader  reader = new BufferedReader(streamReader);
                    System.out.println("server in:   " + reader.readLine());

                    PrintWriter writer = new PrintWriter(sock.getOutputStream());
                    String advice = getadvice();
                    writer.println(advice);
                    writer.close();
                    System.out.println("server out:  " + advice);
                }
            }

        }
        catch(IOException ex){
            ex.printStackTrace();;
        }
    }

    private String getadvice(){
        return "return server ok";
    }

    public static void main(String[] args){
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

}