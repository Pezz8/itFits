package com.example.itfits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, rePassword;
    Button register, signIn;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        rePassword = (EditText) findViewById(R.id.rePassword);
        register = (Button) findViewById(R.id.btnRegister);
        signIn = (Button) findViewById(R.id.btnSignin);
        db = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = rePassword.getText().toString();

                if(user.equals("")||pass.equals("")|repass.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(repass)){
                        Boolean checkUser = db.checkUserName(user);
                        if(checkUser==false){
                            Boolean insert = db.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), UserSetup.class);
                                intent.putExtra("newUser",user);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "User already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}