package trung.nguyen.menuexample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView = findViewById(R.id.textView);

        switch(item.getItemId()){
            case R.id.blue:
                getWindow().getDecorView().setBackgroundColor(BLUE);
                textView.setText("BLUE");
                textView.setTextColor(WHITE);
                return true;
            case R.id.red:
                getWindow().getDecorView().setBackgroundColor(RED);
                textView.setText("RED");
                textView.setTextColor(BLACK);
                return true;
            case R.id.yellow:
                getWindow().getDecorView().setBackgroundColor(YELLOW);
                textView.setText("YELLOW");
                textView.setTextColor(BLACK);
                return true;
            case R.id.green:
                getWindow().getDecorView().setBackgroundColor(GREEN);
                textView.setText("GREEN");
                textView.setTextColor(WHITE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
