package trung.nguyen.lab3_3zoo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textMammals;
    ImageView imageView, imageView2, imageView3, imageView4;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMammals  = (TextView)  findViewById(R.id.textAnimals);
        imageView    = (ImageView) findViewById(R.id.imageView);
        imageView2   = (ImageView) findViewById(R.id.imageView2);
        imageView3   = (ImageView) findViewById(R.id.imageView3);
        imageView4   = (ImageView) findViewById(R.id.imageView4);

        String tag   = imageView.getTag().toString();



        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView.getTag().toString();
                Log.d("Image", "onClick: " + tag);
                if("Bear".equals(tag)){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bear);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.punatulkku_northern_bullfinch);
                    mediaPlayer.start();
                }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView2.getTag().toString();
                Log.d("Image", "onClick: " + tag);
                if("Elephant".equals(tag)){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.elephant);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.peippo_chaffinch);
                    mediaPlayer.start();
                }
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView3.getTag().toString();
                Log.d("Image", "onClick: " + tag);
                if("Wolf".equals(tag)){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.wolf);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.punatulkku_northern_bullfinch);
                    mediaPlayer.start();
                }
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView4.getTag().toString();
                Log.d("Image", "onClick: " + tag);
                if("Wolf".equals(tag)){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lamb);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.peukaloinen_wren);
                    mediaPlayer.start();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        textMammals = (TextView) findViewById(R.id.textAnimals);
        switch (item.getItemId()) {
            case R.id.mammals:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.bear);
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.elephant);
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.lamb);
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.wolf);

                ((ImageView)findViewById(R.id.imageView)).setTag("Bear");
                ((ImageView)findViewById(R.id.imageView2)).setTag("Elephant");
                ((ImageView)findViewById(R.id.imageView3)).setTag("Lamp");
                ((ImageView)findViewById(R.id.imageView4)).setTag("Wolf");
                textMammals.setText("Mammals");
                return true;
            case R.id.birds:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.huuhkaja);
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.peippo);
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.peukaloinen);
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.punatulkku);

                ((ImageView)findViewById(R.id.imageView)).setTag("Huuhkaja");
                ((ImageView)findViewById(R.id.imageView2)).setTag("Peippo");
                ((ImageView)findViewById(R.id.imageView3)).setTag("Peukaloinen");
                ((ImageView)findViewById(R.id.imageView4)).setTag("Punatulku");
                textMammals.setText("Birds");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}