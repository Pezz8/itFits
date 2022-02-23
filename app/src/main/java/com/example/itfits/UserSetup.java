package com.example.itfits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserSetup extends AppCompatActivity {

    EditText userName, chest,waist,hips,inseam;
    Spinner gender;
    Button saveButton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setup);

        chest = (EditText) findViewById(R.id.chestSizeInput);
        waist = (EditText) findViewById(R.id.waistSizeInput);
        hips = (EditText) findViewById(R.id.hipsSizeInput);
        inseam = (EditText) findViewById(R.id.inseamSizeInput);
        gender = (Spinner) findViewById(R.id.genderSpinner);
        saveButton = (Button) findViewById(R.id.btnSaveUserInfo);
        db = new DBHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){



                String username = getIntent().getStringExtra("newUser");
                Double chestSize = Double.parseDouble(chest.getText().toString());
                Double waistSize = Double.parseDouble(waist.getText().toString());
                Double hipSize = Double.parseDouble(hips.getText().toString());
                Double inseamSize = Double.parseDouble(inseam.getText().toString());
                String genderSelect = gender.getSelectedItem().toString();

                UserSize userSize = new UserSize(username,chestSize,waistSize,hipSize,inseamSize,genderSelect);

                if(chestSize.equals("")||waistSize.equals("")||hipSize.equals("")||inseamSize.equals("")){
                    Toast.makeText(UserSetup.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean insert = db.insertSizeData(username,genderSelect,chestSize,waistSize,hipSize,inseamSize);
                    if(insert==true){
                        Toast.makeText(UserSetup.this,"Setup Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("userSizeIntent",userSize.toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(UserSetup.this,"Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}