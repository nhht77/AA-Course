package trung.nguyen.stockmonitor;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Stock[] stocks  = new Stock[4];
        stocks[0]       = new Stock("AAPL", "Apple", 0);
        stocks[1]       = new Stock("GOOGL", "Google", 0);
        stocks[2]       = new Stock("FB", "Facebook", 0);
        stocks[3]       = new Stock("NOK", "Nokia", 0);

        getStock(stocks);

    }

    private void getStock(Stock[] stocks) {

        for (Stock s : stocks) {
            String url = "https://financialmodelingprep.com/api/company/price/" + s.getId() + "?datatype=json";
            Request request = new Request.Builder().url(url).build();
            OkHttpClient client = new OkHttpClient();

            try {
                Response response = client.newCall(request).execute();
                String body       =  response.body().toString();
                Gson gson         = new GsonBuilder().create();
                Log.d("GETSTOCKBODY", "getStock: " + body.toString());
//                StockId json        =  gson.fromJson(body, StockId.class);
//                gson.fromJson()
//                Log.d("GETSTOCKId", "getStock: " +json.getName().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
