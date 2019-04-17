package trung.nguyen.eggtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                String   text     = editText.getText().toString();
                Intent   intent   = new Intent(MainActivity.this, CountDown.class);
                intent.putExtra("num", text);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
