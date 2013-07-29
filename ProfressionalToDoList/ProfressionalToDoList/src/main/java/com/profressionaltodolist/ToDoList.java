package com.profressionaltodolist;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoList extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText) findViewById(R.id.myEditText);
        Button myEnterButton = (Button)findViewById(R.id.enter);

        final ArrayList<String> toDoItems = new ArrayList<String>();
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,R.layout.todoitems,toDoItems);
        myListView.setAdapter(aa);

        myEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEnter(aa,toDoItems,myEditText);
            }
        });

    }

    private void onEnter(ArrayAdapter<String> aa,ArrayList<String> toDoItems,EditText myEditText){
        toDoItems.add(0,myEditText.getText().toString());
        aa.notifyDataSetChanged();
        myEditText.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
