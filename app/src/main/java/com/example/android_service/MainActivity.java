package com.example.android_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 https://www.youtube.com/watch?v=Zcq5wk6FPU0&t=187s
 // video 3: Service : TinCoder
 Start a Foreground Service trong Android (với Notification Channels) - [Service Part 3]

 */
public class MainActivity extends AppCompatActivity {

// Khai báo view ở bên ngoài các vòng đời
    private EditText edt_data_intent;
    private Button btn_start_service;
    private Button btn_stop_service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view ở bên trong vòng đời onCreate
        edt_data_intent = findViewById(R.id.edt_data_intent);
        btn_start_service= findViewById(R.id.btn_start_service);
        btn_stop_service = findViewById(R.id.btn_stop_service);

        btn_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStartService();
            }
        });

        btn_stop_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStopService();
            }
        });
    }

    // Hàm start Service
    private void clickStartService() {
        // Put dữ liệu thông qua Intent này luôn
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key_data_intent", edt_data_intent.getText().toString().trim());  // Đưa dữ liệu vào với cái key là key_data_intent
        startService(intent);
    }

    // Hàm Stop Service
    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);

    }


}