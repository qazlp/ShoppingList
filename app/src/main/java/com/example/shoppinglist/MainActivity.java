package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout list;

    public static final int TEXT_REQUEST = 1;

    TextView item1;
    TextView item2;
    TextView item3;
    TextView item4;
    TextView item5;
    TextView item6;
    TextView item7;
    TextView item8;
    TextView item9;
    TextView item10;

    private static int count = -1;
    private static int prevCount;
    private static final String LOG_TAG = MainActivity.class.getName().toString();

    private static TextView[] actual = new TextView[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actual[0] = findViewById(R.id.item1);
        actual[1] = findViewById(R.id.item2);
        actual[2] = findViewById(R.id.item3);
        actual[3] = findViewById(R.id.item4);
        actual[4] = findViewById(R.id.item5);
        actual[5] = findViewById(R.id.item6);
        actual[6] = findViewById(R.id.item7);
        actual[7] = findViewById(R.id.item8);
        actual[8] = findViewById(R.id.item9);
        actual[9] = findViewById(R.id.item10);


    }

    public void createItem(View view) {
        count++;
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String fruite = data.getStringExtra(ItemsActivity.EXTRA_ITEM);
                actual[count].setText(fruite);
            }
        }
    }
}
