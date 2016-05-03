package serveur;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public abstract class ServeurThreadTCP {
    
    private ServerSocket srv;

    public ServeurThreadTCP(int port) throws IOException {
        this.srv = new ServerSocket(port);
    }
    
    public void go() throws IOException {

        ThreadGroup thg = new ThreadGroup("serveur"){
            public void uncaughtException(Thread t, Throwable e) {
                Logger.global.log(Level.SEVERE,t.toString(), e);
            }
        };
       
        while (true) {
            Socket sck = srv.accept();
            new Thread(thg, fabriqueSession(sck)).start();
        }
        
    }
    
    public abstract Runnable fabriqueSession(Socket sck);
    
    
}
