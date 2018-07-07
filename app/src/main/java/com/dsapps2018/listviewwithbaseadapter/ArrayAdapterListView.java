package com.dsapps2018.listviewwithbaseadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Daniel on 7/7/2018.
 */

public class ArrayAdapterListView extends ArrayAdapter<Products> {
    private final Activity context;
    private ArrayList<Products> productList;
    private int itemCount = 0;
    public ArrayList<Products> tempListItems = new ArrayList<>();


    public ArrayAdapterListView(Activity context, ArrayList<Products> list) {
        super(context, R.layout.item_row, list);
        this.context = context;
        this.productList = list;
        itemCount = list.size();

        for(Products item : productList){
            if(item.isChecked()){
                tempListItems.add(item);
            }
        }

    }


    static class ViewHolder {

        protected TextView title;
        protected CheckBox checkBox;

    }


    @Override
    public int getCount() {
        return itemCount;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;
        final Products product = productList.get(position);


        if (convertView == null) {


            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_row, null);
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.titleTextView);
            viewHolder.checkBox = convertView.findViewById(R.id.checkBox);

//           viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//               @Override
//               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//               }
//           });

           viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {

                   int getPosition = (Integer)v.getTag();
                   productList.get(getPosition).setChecked(((CheckBox)v).isChecked());

                   if(((CheckBox)v).isChecked()){
                       Toast.makeText(context, "Item: "+ product.getTitle() + "je setovan na "+ String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();
                       product.setChecked(true);
                       tempListItems.add(product);
                   }else{
                       Toast.makeText(context, "Item: "+ product.getTitle() + "je setovan na "+ String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();

                       product.setChecked(false);
                       tempListItems.remove(product);
                   }
               }
           });


            convertView.setTag(viewHolder);
            convertView.setTag(R.id.titleTextView, viewHolder.title);
            convertView.setTag(R.id.checkBox, viewHolder.checkBox);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.checkBox.setTag(position);

        viewHolder.title.setText(productList.get(position).getTitle());
        viewHolder.checkBox.setChecked(productList.get(position).isChecked());


        return convertView;
    }

    public void findList(ArrayList<Products> arrayList){

        productList = arrayList;
        itemCount = arrayList.size();
        notifyDataSetChanged();
    }

    public ArrayList<Products> getList(){
        return  tempListItems;
    }
}
