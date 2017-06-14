package design.tanuj.xmlparser;

/**
 * Created by Tanuj Saraf on 6/14/2017.
 */
public class Beacon {
    private String IP;
    private String Name;



    public String getIP() {
        return IP;
    }


    public void setIP(String IP) {
        this.IP = IP;
    }


    public String getName() {
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }


    @Override
    public String toString() {
        return " IP= "+IP + "\n Name= " + Name;
    }
}