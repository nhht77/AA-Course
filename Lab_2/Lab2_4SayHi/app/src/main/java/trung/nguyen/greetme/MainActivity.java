package trung.nguyen.greetme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView textView = null;
    TextView textEdit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textEdit = findViewById(R.id.editText);

        textView.setText("What is your name?");

        findViewById(R.id.btnEng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textEdit.getText().toString();

                if (name.isEmpty() && name == null && name.length() < 0) {
                    textView.setText("Please Type Your name");
                } else {
                    textView.setText("Hello " + name + " from London");
                }
            }
        });

        findViewById(R.id.btnSuomi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textEdit.getText().toString();
                if (name == null && name.length() < 0) {
                    textView.setText("Please Type Your name");
                } else {
                    textView.setText("Moi " + name + " Oulusta");
                }
            }
        });

        findViewById(R.id.btnJp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textEdit.getText().toString();
                if (name == null && name.length() < 0) {
                    textView.setText("Please Type Your name");
                } else {
                    textView.setText("東京からこんにちは " + name);
                }
            }
        });

        findViewById(R.id.btnCn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textEdit.getText().toString();
                if (name == null && name.length() < 0) {
                    textView.setText("Please Type Your name");
                } else {
                    textView.setText("西安你好 " + name);
                }
            }
        });
    }
}
