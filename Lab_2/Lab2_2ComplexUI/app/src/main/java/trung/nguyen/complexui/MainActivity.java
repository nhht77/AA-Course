package trung.nguyen.complexui;

import android.annotation.SuppressLint;
import android.content.Context;
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

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        LinearLayout parent   = findViewById(R.id.parent);

        LinearLayout btnGroup = new LinearLayout(this);
        btnGroup.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnGroup.setGravity(Gravity.CENTER);
        btnGroup.setPadding(0, 10, 0, 10);
        btnGroup.setOrientation(LinearLayout.HORIZONTAL);

        final Button addBtn     = new Button(this);
        Button editBtn    = new Button(this);
        Button removeBtn  = new Button(this);

        final EditText editText = new EditText(this);
        ListView listView = new ListView(this);

        addBtn.setText("Add");
        editBtn.setText("Edit");
        removeBtn.setText("Add");

        btnGroup.addView(addBtn);
        btnGroup.addView(editBtn);
        btnGroup.addView(removeBtn);

        parent.addView(btnGroup);
        parent.addView(editText);
        parent.addView(listView);

        initAdapter(listView);

    }

    private void initAdapter(ListView listView) {
        final String[] countries = new String[] {"Paraguay ", "Costa Rica ", "Panama", "Philippines",
                "Uzbekistan", "Ecuador", "Guatemala", "Mexico", "Norway", "Chile", "Colombia"};
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, countries);
        listView.setAdapter(aa);
    }

    private void addCountry(EditText editText){
        String text = editText.getText().toString();
        Log.d("AddCountries", "addCountry: " + text);
    }
}
