package serveur;

import java.rmi.*;
import java.util.ArrayList;
import java.util.List;

public class ServeurRmi {
    
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("14/10/2015");
        l.add("14/11/2015");
        
        try {
            //Naming.rebind("Dispos", new Dispos(l));
            System.out.println("Server is connected and ready for operation.");
        } catch (Exception e) {
            System.out.println ("Server not connected: " + e);
        }
    }
    
    
}
