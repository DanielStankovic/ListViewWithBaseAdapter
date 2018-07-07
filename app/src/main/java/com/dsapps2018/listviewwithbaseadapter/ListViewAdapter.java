package com.dsapps2018.listviewwithbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Daniel on 7/7/2018.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Products> productList;
    private ArrayList<Products> tempList = new ArrayList<>();

    public ListViewAdapter(Context ctx,ArrayList<Products> productList ){

        this.context = ctx;
        this.productList = productList;

        for (int i = 0; i <20 ; i++) {
            if(i%3 == 0){
                productList.get(i).setChecked(true);
            }else{
                productList.get(i).setChecked(false);
            }

        }

        for(Products prod : productList){
            if(prod.isChecked())
                tempList.add(prod);

        }

    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
         if(convertView == null){

             convertView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
             viewHolder = new ViewHolder(convertView);
             convertView.setTag(viewHolder);


         }else{
             viewHolder = (ViewHolder) convertView.getTag();
         }

         final Products products = (Products) getItem(position);
         viewHolder.title.setText(products.getTitle());

         viewHolder.checkBox.setChecked(products.isChecked());

         viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if(((CheckBox)v).isChecked()){

                     products.setChecked(true);
                     tempList.add(products);


                     Toast.makeText(context, "Item: "+ products.getTitle() + "je setovan na "+ String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();

                 }else{
                     products.setChecked(false);
                     tempList.remove(products);
                     Toast.makeText(context, "Item: "+ products.getTitle() + "je setovan na "+ String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();

                 }
             }
         });



        return convertView;
    }

    private class ViewHolder {

        public TextView title;

        public CheckBox checkBox;

        public ViewHolder (View view){

            title = view.findViewById(R.id.titleTextView);

            checkBox = view.findViewById(R.id.checkBox);
        }

    }

    public void findList(ArrayList<Products> arrayList){

        productList = arrayList;
   //     itemCount = arrayList.size();
        notifyDataSetChanged();
    }

    public ArrayList<Products> getList(){
        return  tempList;
    }

}
