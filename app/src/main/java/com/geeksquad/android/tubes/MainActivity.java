package com.geeksquad.android.tubes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    public EditText edUser;
    public EditText edPass;
    public Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
        edUser = (EditText) findViewById(R.id.edUsername);
        edPass = (EditText) findViewById(R.id.edPassword);
        login = (Button) findViewById(R.id.login);
        String stuser = edUser.getText().toString();
        String stpass = edPass.getText().toString();
    }

    public  void login(View v){
        String stuser = edUser.getText().toString();
        String stpass = edPass.getText().toString();

        if(stuser.equals("admin") && stpass.equals("admin")){
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        }
    }


}
