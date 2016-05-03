package hote;

import java.io.IOException;
import java.net.Socket;

public class Hote {

    public static void main(String[] args) {
        Socket socket;
        
        HoteConnexionInterface h = new HoteConnexionInterface();
        h.setVisible(true);
        
	try {
            //socket = new Socket("localhost",Integer.parseInt(args[0]));
             socket = new Socket("localhost",9999);
            socket.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
}
