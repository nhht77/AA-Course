package trung.nguyen.lab4_3stockmonitorv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public JSONObject jsonObject;
    public ArrayAdapter<String> arrayAdapter;
    public ArrayList<String> stockList;
    EditText stockID;
    EditText stockName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.stockList);
        final Button   addStock = findViewById(R.id.addStock);
        stockID           = findViewById(R.id.stockId);
        stockName         = findViewById(R.id.stockName);

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

        addStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStock();
            }
        });

    }

    private void addStock() {
        final String StockId = this.stockID.getText().toString();
        final String StockName = this.stockName.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://financialmodelingprep.com/api/company/price/" + StockId + "?datatype=json";
        Log.d("STOCKURL", "STOCKUrl: " + url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonObject    = response.getJSONObject(StockId);
                            double price  = (double) jsonObject.get("price");
                            MainActivity.this.stockList.add(StockName + ": " + price);
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

    private void getStock(Stock[] stocks, final ArrayAdapter<String> arrayAdapter) {

        RequestQueue queue = Volley.newRequestQueue(this);

        for (final Stock s : stocks) {
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
