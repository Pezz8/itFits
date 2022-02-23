package com.example.itfits;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//public class MyAdapter extends BaseAdapter {
public class MyAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] brandNames;
    ArrayList<CloathingItem> arrayList;
    UserSize userSize;

//    public MyAdapter(Context context, ArrayList<CloathingItem> arrayList){
//        this.context = context;
//        this.arrayList = arrayList;
//    }

    public MyAdapter(Context context, int[] brandImages, String[] brandNames, ArrayList<CloathingItem> itemList,UserSize userSize){
        super(context,R.layout.single_item,R.id.brandView1,brandNames);
        this.context = context;
        this.images = brandImages;
        this.brandNames = brandNames;
        //this.arrayList = itemList;
        this.userSize = userSize;
        this.arrayList = filterList(itemList,userSize);
    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

//    @Override
//    public Object getItem(int position) {
//        return this.arrayList.get(position);
//    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        ProgramViewHolder holder = null;
        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item, parent,false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            holder = (ProgramViewHolder) singleItem.getTag();
        }

        CloathingItem item = arrayList.get(position);

        int pos = new ArrayList<String>(Arrays.asList(brandNames)).indexOf(item.getItemBrand());

            if (pos == -1) {
                pos = 0;
                Log.d("My Current Brand: ", item.getItemBrand());
            }

            holder.itemImage.setImageResource(images[pos]);
            holder.itemBrand.setText(item.getItemBrand());
            holder.itemType.setText(item.getItemType());
            holder.itemSize.setText(item.getItemSize());



        return singleItem;
        }


        public ArrayList<CloathingItem> filterList(ArrayList<CloathingItem>itemList,UserSize userSize){
        ArrayList<CloathingItem> temp = new ArrayList<>();
        for(int i = 0;i<itemList.size();i++){
            if(itemList.get(i).getItemType()=="Tops") {
                if (userSize.getChestSize() >= itemList.get(i).getItemChestMin() && userSize.getChestSize() < itemList.get(i).getItemChestMax()) {
                    temp.add(itemList.get(i));
                }
            }
            else{
                if(userSize.getWaistSize()>= itemList.get(i).getItemWaistMin()&& userSize.getWaistSize() < itemList.get(i).getItemWaistMax()){
                    temp.add(itemList.get(i));
                }
            }
        }
        return temp;
        }


    public Boolean doesItemFitUser(UserSize userSize, CloathingItem item){
        Boolean flag = false;

        if(item.getItemType()=="Tops"){
            if(((userSize.getChestSize()>=item.getItemChestMin())&&(userSize.getChestSize()<item.getItemChestMax()))){
                    flag = true;
                }
            }

        return flag;
    }

    }




