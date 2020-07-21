package com.example.testacazia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LogOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
    }

    public void logout(View view) {
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);  SharedPreferences sharedPreferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("remamber","false");
        editor.apply();

        finish();
    }
}