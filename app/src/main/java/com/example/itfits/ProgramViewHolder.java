package com.example.itfits;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {
    ImageView itemImage;
    TextView itemBrand;
    TextView itemType;
    TextView itemSize;

    ProgramViewHolder(View v){
        itemImage = v.findViewById(R.id.imageView);
        itemBrand = v.findViewById(R.id.brandView1);
        itemType = v.findViewById(R.id.cloathingType1);
        itemSize = v.findViewById(R.id.cloathingSize1);
    }
}
