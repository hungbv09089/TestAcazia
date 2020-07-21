package com.example.testacazia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText edtemail,edtpass;
    CheckBox cbxrb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtemail=findViewById(R.id.edtacc);
        edtpass=findViewById(R.id.edtpass);
        cbxrb=findViewById(R.id.cbxRM);
        initPreferences();

        String data=sharedPreferences.getString("DATA","");
        edtemail.setText(data);
        edtpass.setText(data);
    }
    private void initPreferences() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    public void login(View view) {

        String repass="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        if(edtpass.getText().toString().equals("")||edtemail.getText().toString().equals("")){
            Toast.makeText(this,"Không được để trống email và pass",Toast.LENGTH_SHORT).show();}
        else if(!repass.matches(edtpass.getText().toString())){
            Toast.makeText(this,"Mật khẩu phải có 6 kí tự và 1 chữ số, 1 kí tự đặc biệt",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,LogOut.class);
            startActivity(intent);
        }
}

    @Override
    public void onClick(View view) {
        if (view==cbxrb){
            String dataemail=edtemail.getText().toString();
            String datapass=edtpass.getText().toString();
            editor.putString("DATA",dataemail);
            editor.putString("DATA",datapass);
            editor.commit();

        }
    }
}