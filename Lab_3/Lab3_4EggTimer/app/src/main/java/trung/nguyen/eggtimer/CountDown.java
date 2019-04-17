package trung.nguyen.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountDown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        String intentData  = getIntent().getStringExtra("num");
        int    num         = Integer.parseInt(intentData);


        new CountDownTimer((num + 1) * 1000, 1000){
            TextView countDown = findViewById(R.id.countDown);

            @Override
            public void onTick(long l) {
                String num = Long.toString(l/1000);
                countDown.setText(num);
            }

            @Override
            public void onFinish() {
                countDown.setText("Times Up!");
            }
        }.start();
    }
}
