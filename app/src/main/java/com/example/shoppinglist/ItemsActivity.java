package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/*
 * This is class that represented Items List, where user
 * can choose some list item and add to own list, that's represent MainActivity
 * Step 1. Add new methods separate for each item in list
 * Step 2. Add new keys for extra like static private and final
 * Step 3.
 */

public class ItemsActivity extends AppCompatActivity {


    public static final String EXTRA_ITEM = "com.example.shoppinglist.item";

    public static final String LOG_TAG = ItemsActivity.class.getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void AddItem(View view) {

        //get id by item
        int idFromParent = ((View) view.getParent()).getId();

        // set
        LinearLayout ll = findViewById(idFromParent);
        TextView text = (TextView) ll.getChildAt(0);
//text.getText().toString()
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_ITEM, text.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
