package design.tanuj.xmlparser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


public class XmlPullParserHandler {
    private List<Beacon> beacons = new ArrayList<Beacon>();
    private Beacon beacon;
    private String text;

    public List<Beacon> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("host")) {
                            // create a new instance of host
                            beacon = new Beacon();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("host")) {
                            // add host object to list
                            beacons.add(beacon);
                        }else if (tagname.equalsIgnoreCase("ip")) {
                            beacon.setIP(text);
                        }  else if (tagname.equalsIgnoreCase("name")) {
                            beacon.setName(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return beacons;
    }
}