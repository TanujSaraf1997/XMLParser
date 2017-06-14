package design.tanuj.xmlparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.listView1);

        List<Beacon> beacons = null;
        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            InputStream is=getAssets().open("BeaconList.xml");
            beacons = parser.parse(is);

            ArrayAdapter<Beacon> adapter =new ArrayAdapter<Beacon>(this,android.R.layout.simple_list_item_1, beacons);
            listView.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}

    }
}
