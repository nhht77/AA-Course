package trung.nguyen.lab2_3_countries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout parent   = findViewById(R.id.parent);

        LinearLayout btnGroup = new LinearLayout(this);
        btnGroup.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnGroup.setGravity(Gravity.CENTER);
        btnGroup.setPadding(0, 10, 0, 10);
        btnGroup.setOrientation(LinearLayout.HORIZONTAL);

        final Button addBtn     = new Button(this);
        Button editBtn    = new Button(this);
        Button removeBtn  = new Button(this);

        EditText editText = new EditText(this);
        editText.setWidth(200);
        editText.setHint("Enter a country name...");
        ListView listView = new ListView(this);


        addBtn.setText("Add");
        editBtn.setText("Edit");
        removeBtn.setText("Remove");

        btnGroup.addView(addBtn);
        btnGroup.addView(editBtn);
        btnGroup.addView(removeBtn);

        parent.addView(btnGroup);
        parent.addView(editText);
        parent.addView(listView);

        final ArrayList<String> countries = new ArrayList<String>();
        countries.add("Paraguay");
        countries.add("Costa Rica");
        countries.add("Panama");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries);
        listView.setAdapter(arrayAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPressed(editText, countries, arrayAdapter);
            }
        });
        
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removePressed(editText, countries, arrayAdapter);
            }
        });
    }

    private void removePressed(EditText editText, ArrayList<String> countries, ArrayAdapter<String> arrayAdapter) {
        String editTxt = editText.getText().toString().toLowerCase();
        editText.setText(null);

        for (String c : countries) {
            if (c.contains(editTxt)) {
                countries.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }

    private void addPressed(EditText editText, ArrayList<String> countries, ArrayAdapter<String> arrayAdapter) {
        String editTxt = editText.getText().toString();
        if (editTxt != null && editTxt.length() > 0) {
            editText.setText(null);
            countries.add(editTxt);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    private void updateCountriesView(ListView listView, ArrayList<String> countries) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries);
        listView.setAdapter(arrayAdapter);
    }
}
