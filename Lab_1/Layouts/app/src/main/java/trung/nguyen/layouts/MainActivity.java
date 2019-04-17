package trung.nguyen.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] countries = new String[] {"Paraguay ", "Costa Rica ", "Panama", "Philippines",
                "Uzbekistan", "Ecuador", "Guatemala", "Mexico", "Norway", "Chile", "Colombia"};
        ListView myListView      = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, countries);
        myListView.setAdapter(aa);
    }
}
