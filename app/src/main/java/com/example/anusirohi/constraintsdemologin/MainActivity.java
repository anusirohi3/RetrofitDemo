package com.example.anusirohi.constraintsdemologin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    RecyclerView country_list;
    ArrayList<String> name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Log.d("on create", "------on create");
        inihgkt();
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("on start", "------on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("on resume", "------on resume");

        Intent intent = this.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
        int percent = (level * 100) / scale;
        Toast.makeText(this, "fhgvhfv" + percent + "%", Toast.LENGTH_SHORT).show();
//        registerReceiver(batteryChangeReceiver, new IntentFilter(
//                Intent.ACTION_BATTERY_CHANGED));
    }

    private void init() {
        try {
//            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = new JSONArray(loadJSONFromAsset());
            name = new ArrayList();
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                name.add(jo_inside.optString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        InputStream is = getResources().openRawResource(R.raw.country);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return writer.toString().trim();
    }

    public class BatteryChangeReceiver extends BroadcastReceiver {

        int scale = -1;
        int level = -1;
        int voltage = -1;
        int temp = -1;

        @Override
        public void onReceive(Context context, Intent intent) {
            level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
            voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("on pause", "------on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("on stop", "------on stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("on destroy", "------on destroy");
    }

    private void inihgkt() {
//        final EditText et_pass = findViewById(R.id.et_pass);
//        final EditText et_user_name = findViewById(R.id.et_user_name);
        Button btn_lgn = findViewById(R.id.button_login);
        btn_lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (et_user_name.getText().toString().trim().equalsIgnoreCase("Anu Sirohi") &&
//                        et_pass.getText().toString().trim().equalsIgnoreCase("123456789")) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("dsgdag", name);
                startActivity(intent);
//                } else Toast.makeText(MainActivity.this, "Get Lost", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
