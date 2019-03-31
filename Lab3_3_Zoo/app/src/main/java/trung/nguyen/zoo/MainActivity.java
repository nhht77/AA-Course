package trung.nguyen.zoo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static trung.nguyen.zoo.R.raw.bear;

public class MainActivity extends AppCompatActivity {

    TextView textMammals;
    ImageView imageView, imageView2, imageView3, imageView4;
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMammals  = (TextView)  findViewById(R.id.textAnimals);
        imageView    = (ImageView) findViewById(R.id.imageView);
        imageView2   = (ImageView) findViewById(R.id.imageView2);
        imageView3   = (ImageView) findViewById(R.id.imageView3);
        imageView4   = (ImageView) findViewById(R.id.imageView4);

        String tag1 = imageView.getTag().toString();
//        String tag2 = imageView2.getTag().toString();
//        String tag3 = imageView3.getTag().toString();
//        String tag4 = imageView4.getTag().toString();

        if(tag1 == "Bear"){
            mediaPlayer1 = MediaPlayer.create(this, R.raw.bear);
        } else {
            mediaPlayer1 = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);
        }
//
//        if(tag2 == "Elephant"){
//            mediaPlayer2 = MediaPlayer.create(this, R.raw.elephant);
//        } else {
//            mediaPlayer2 = MediaPlayer.create(this, R.raw.peippo_chaffinch);
//        }
//
//        if(tag3 == "Lamp"){
//            mediaPlayer3 = MediaPlayer.create(this, R.raw.lamb);
//        } else {
//            mediaPlayer3 = MediaPlayer.create(this, R.raw.peukaloinen_wren);
//        }
//
//        if(tag4 == "Wolf"){
//            mediaPlayer1 = MediaPlayer.create(this, R.raw.wolf);
//        } else {
//            mediaPlayer1 = MediaPlayer.create(this, R.raw.punatulkku_northern_bullfinch);
//        }


        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView.getTag().toString();
                Log.d("Image", "onClick: " + tag);
                mediaPlayer1.start();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView2.getTag().toString();
                Log.d("Image", "onClick: " + tag);
//                mediaPlayer2.start();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView3.getTag().toString();
                Log.d("Image", "onClick: " + tag);
//                mediaPlayer3.start();
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tag = imageView4.getTag().toString();
                Log.d("Image", "onClick: " + tag);
//                mediaPlayer4.start();
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
