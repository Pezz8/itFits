package com.example.itfits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnSignIn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnSignIn = (Button) findViewById(R.id.btnSignin1);
        db = new DBHelper(this);


        btnSignIn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){

            String user = username.getText().toString();
            String pass = password.getText().toString();

            UserSize userSize = new UserSize();

            if(user.equals("")||pass.equals("")) {
                Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean checkUserPass = db.checkUserNamePassword(user, pass);
                if(checkUserPass == true){
                    userSize = new UserSize(db.getUserSizeFromDB(user));
                    Toast.makeText(LoginActivity.this, "Sign in succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("userSizeIntent", userSize.toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        }
        });

    }
}