import java.io.*;
import java.net.*;

public class DailyAdviceClient{
    
    public void go(){
        try{
            try (Socket s = new Socket("127.0.0.1", 4242)) {

                PrintWriter writer = new PrintWriter(s.getOutputStream());
                writer.println(" ok___clcl");
                writer.flush();

                System.out.println("Client send ok" );

                InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
                BufferedReader  reader = new BufferedReader(streamReader);

                String advice = reader.readLine();
                System.out.println("Client:    _____" +  advice);
                reader.close();
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}