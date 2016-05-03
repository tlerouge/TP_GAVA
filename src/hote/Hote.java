package hote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Hote {

    private Socket socket;
    
    public static void main(String[] args) {
        
        
        HoteConnexionInterface h = new HoteConnexionInterface();
        h.setVisible(true);
        
    }
    
    public boolean connect(String Nom){
       
        try {
            socket = new Socket("localhost", 9999);
            System.out.println("Communication établie");
            
            BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            
            PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

            pred.println(Nom);
            
            String retour = plec.readLine();
            System.out.println(retour);
            plec.close();
            pred.close();
            
            if (retour.equals("1")){
                System.out.println("Connexion accepté");
                return true;
            }
            else {
                System.out.println("Connexion refusé");
                return false;
            } 
            
        } catch (IOException ex) {
            Logger.getLogger("Connexion échoué");
            return false;
        } 
    }
        
    public void disconnect () throws IOException{
        socket.close();
        System.out.println("Connexion fermé");
    }
    
}
