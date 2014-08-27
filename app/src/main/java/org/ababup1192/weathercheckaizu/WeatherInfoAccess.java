package org.ababup1192.weathercheckaizu;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.ababup1192.weathercheckaizu.util.volley.GsonRequest;
import org.json.JSONObject;


public class WeatherInfoAccess {

    public static final String TAG = WeatherInfoAccess.class.getSimpleName();

    public static void get(Context context) {
        RequestQueue requestQueue;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=AizuWakamatsu,jp";
        requestQueue = Volley.newRequestQueue(context);
        GsonRequest<WeatherInfo> request = new GsonRequest<WeatherInfo>(Request.Method.GET, url,
                WeatherInfo.class, null,
                new Response.Listener<WeatherInfo>() {
                    @Override
                    public void onResponse(WeatherInfo response) {
                        // JSONObjectのパース、List、Viewへの追加等
                        Log.d(TAG, String.valueOf(response.main.temp));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // エラー処理 error.networkResponseで確認
                        // エラー表示など
                        if (error == null) {
                            Log.d(TAG, "error null");
                        } else {
                            Log.d(TAG, error.toString());
                        }
                    }
                });
        requestQueue.add(request);
        requestQueue.start();
    }

}
