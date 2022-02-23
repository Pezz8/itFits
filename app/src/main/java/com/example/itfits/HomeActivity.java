package com.example.itfits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView fittingItems;
    TextView brand,size,type;
    DBHelper databaseHelper;
    ArrayList<CloathingItem> itemList;
    MyAdapter myAdapter;

    String userSizeInt;
    UserSize temp = new UserSize();
    UserSize userSize = new UserSize();

    String[] brandName = {"Adidas","Diesel","Gucci","Hugo Boss","Lee","Nike","Puma"};
    int[] brandImages = {R.drawable.adidas, R.drawable.diesel,R.drawable.gucci,R.drawable.hugo,R.drawable.lee,
             R.drawable.nike,R.drawable.puma};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        brand = (TextView) findViewById(R.id.brandView1);
//        size = (TextView) findViewById(R.id.cloathingSize1);
//        type = (TextView) findViewById(R.id.cloathingType1);
        fittingItems = findViewById(R.id.brands);
        databaseHelper = new DBHelper(this);
        itemList = new ArrayList<>();
        userSizeInt = getIntent().getStringExtra("userSizeIntent");
        userSize = new UserSize(temp.fromString(userSizeInt));
        loadDataInListView();
    }

    private void loadDataInListView(){
        itemList = databaseHelper.getAllDataFilterGender(userSize.getGender());
        myAdapter = new MyAdapter(this,brandImages,brandName,itemList,userSize);
        fittingItems.setAdapter(myAdapter);
    }
}