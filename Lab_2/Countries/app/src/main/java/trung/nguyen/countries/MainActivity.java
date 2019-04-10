package trung.nguyen.countries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries = new ArrayList();

    TextView textEditor = null;
    ListView countriesList   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditor = findViewById(R.id.text_editor);
        countriesList = findViewById(R.id.country_list_view);

        countries.add(new Country("Afghanistan"));
        countries.add(new Country("Finland"));
        countries.add(new Country("Norway"));
        countries.add(new Country("Sweden"));
        countries.add(new Country("Germany"));

        System.out.println(countries);
    }

//    private void appendCountry(Country country) {
//        countriesList.append(country.getName() + "\n");
//        countriesList.append("\n\n");
//    }
//
//    protected void updateCountriesView() {
//        for(int i = 0; i < countries.size(); i++) {
//            appendCountry(countries.get(i));
//        }
//    }
}

