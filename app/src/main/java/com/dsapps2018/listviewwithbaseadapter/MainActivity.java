package com.dsapps2018.listviewwithbaseadapter;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Products> itemsList;
    private ListViewAdapter adapter;
    private ListView listView;
    private EditText seatchEditText;
    private Button btnExport;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seatchEditText = findViewById(R.id.search_bar);
        btnExport = findViewById(R.id.exportBtn);

        itemsList = new ArrayList<>();

        for (int i = 0; i <20 ; i++) {
            Products item = new Products();
            item.setTitle("Naslov "+ i);

            itemsList.add(item);
        }

        listView = findViewById(R.id.listView);
        adapter = new ListViewAdapter(this, itemsList);
        listView.setAdapter(adapter);

      //  listView.setOnItemClickListener(this);

        seatchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });

        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Products> lista = adapter.getList();

                String RADDIIII = "RADI!";

            }
        });

    }


    public void filter(String text) {

        ArrayList<Products> newList = new ArrayList<>();

        for (Products model : itemsList) {


            if (model.getTitle().toLowerCase().contains(text.toLowerCase())) {
                newList.add(model);
            }
        }
        adapter.findList(newList);
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        TextView title = (TextView) view.getTag(R.id.titleTextView);
//        CheckBox checkBox = (CheckBox)view.getTag(R.id.checkBox);
//        Toast.makeText(view.getContext(), title.getText().toString()+ " " + isCheckedOrNot(checkBox), Toast.LENGTH_SHORT).show();
//    }
//
//    private String isCheckedOrNot(CheckBox checkbox) {
//        if(checkbox.isChecked())
//            return "is checked";
//        else
//            return "is not checked";
//    }


}
