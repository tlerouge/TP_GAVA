package serveur;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.*;

public class ConnexionTCP extends ServeurThreadTCP {
    
    public ArrayList<String> noms = new ArrayList<String>();

    public ConnexionTCP(int port) throws IOException {
        super(port);
    }
    
    public Runnable fabriqueSession(final Socket sck) {
        
        return new Runnable () {
            public void run() {
                String clientSentence;
                String capitalizedSentence;
                try {
                    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sck.getInputStream()));
                    DataOutputStream outToClient = new DataOutputStream(sck.getOutputStream());
                    clientSentence = inFromClient.readLine();
                    System.out.println("Received: " + clientSentence);
                    if (noms.contains(clientSentence)) {
                        outToClient.writeBytes("0");
                    } else {
                        noms.add(clientSentence);
                        outToClient.writeBytes("1");
                    }
                } catch (IOException exc) {
                    Logger.global.log(Level.SEVERE,"thread serv",exc) ;
                }
            }
        };
    }
    
    public static void main(String args[]) throws Exception {
        //ConnexionTCP c = new ConnexionTCP(Integer.parseInt(args[0]));
        ConnexionTCP c = new ConnexionTCP(9999);
        c.go();
        ServeurInterface i = new ServeurInterface();
        i.setVisible(true);
              
    }

    
}