package com.example.itfits;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ClothingItemView {

    ImageView itemImage;
    TextView brandName;
    TextView size;
    TextView itemType;

    ClothingItemView(View view){
        itemImage = view.findViewById(R.id.imageView);
        brandName = view.findViewById(R.id.brandView1);
        size = view.findViewById(R.id.cloathingSize1);
        itemType = view.findViewById(R.id.cloathingType1);
    }
}
