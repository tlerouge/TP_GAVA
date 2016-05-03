package serveur;

import java.util.*;

public class Dispos {

    private List<String> dates;
    
    public Dispos (List<String> dates) {
        this.dates = dates;
    }
    
    public List<String> getDates() {
        return dates;
    }
    
    public boolean reserver(String d) {
        if (dates.contains(d)) {
            return false;
        } else {
            dates.remove(d);
            return true;
        }
         
    }
    
}
