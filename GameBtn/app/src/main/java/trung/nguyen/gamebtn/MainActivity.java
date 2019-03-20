package trung.nguyen.gamebtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gameBtn = null;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button gameBtn = new Button(this);
        gameBtn.setText("Hello, I'm a Button to be pushed!!");
        setContentView(gameBtn);

        gameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                System.out.println("Hi, I'm have been pressed for " + count + " times!");
                gameBtn.setText("Hi, I'm have been pressed for " + count + " times!");
            }
        });
    }
}
