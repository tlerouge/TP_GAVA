/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Baptiste
 */
public class Client {

    private Socket sck;
    boolean sckFerme;   // flag pour savoir si la socket a déjà été fermé
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Client.port=Integer.parseInt(args[0]);
       
        ClientConnexionInterface connexionInterface = new ClientConnexionInterface();
        connexionInterface.setVisible(true);
    }
    
    public boolean connect(String Nom){
       
        try {
            sck = new Socket("localhost", 9999);
            System.out.println("Connexion etabli");
            
            BufferedReader plec = new BufferedReader(new InputStreamReader(sck.getInputStream())); 
            
            PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sck.getOutputStream())),true);

            pred.println(Nom);
            
            String retour = plec.readLine();
            System.out.println(retour);
            plec.close();
            pred.close();
            
            if (retour.equals("1")){
                sckFerme=false;
                System.out.println("Connexion accepté");
                return true;
            }
            else {
                return false;
            } 
            
        } catch (IOException ex) {
            Logger.getLogger("Connexion échoué");
            return false;
        } 
    }
        
    public void disconnect() throws IOException{
        
        if (sckFerme == false){
            sck.close();
            sckFerme=true;
            System.out.println("Connexion fermé");
        }
        else System.out.println("Connexion déjà fermé");
    }
    
}
