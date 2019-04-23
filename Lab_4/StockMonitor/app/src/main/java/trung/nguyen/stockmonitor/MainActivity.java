package trung.nguyen.stockmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.json.JSONException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public JSONObject jsonObject;
    public ArrayAdapter<String> arrayAdapter;
    public ArrayList<String> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.stockList);

        Stock[] stocks  = new Stock[4];
        stocks[0]       = new Stock("AAPL", "Apple", 0);
        stocks[1]       = new Stock("GOOGL", "Google", 0);
        stocks[2]       = new Stock("FB", "Facebook", 0);
        stocks[3]       = new Stock("NOK", "Nokia", 0);

        stockList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                stockList);
        listView.setAdapter(arrayAdapter);
        getStock(stocks, arrayAdapter);
    }


    private void getStock(Stock[] stocks, ArrayAdapter<String> arrayAdapter) {

        RequestQueue queue = Volley.newRequestQueue(this);

        for (Stock s : stocks) {
            String url = "https://financialmodelingprep.com/api/company/price/" + s.getId() + "?datatype=json";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                jsonObject    = response.getJSONObject(s.getId().toString());
                                double price  = (double) jsonObject.get("price");
                                s.setPrice((double) jsonObject.get("price"));
                                MainActivity.this.stockList.add(s.getName() + ": " + s.getPrice());
                                arrayAdapter.notifyDataSetChanged();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.getStackTrace();
                        }
                    });
            queue.add(jsonObjectRequest);
        }
    }
}
