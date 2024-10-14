package com.example.week6_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    final String[] tv = { "흑백요리사", "냉장고를 부탁해", "골목식당", "나는솔로", "환승연애", "강철부대", "최강야구", "런닝맨", "X맨", "SNL" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        int i = 0;
        ArrayAdapter<String> adapter;

        if(i == 2) {
            adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tv);
        } else if (i == 1) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, tv);
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        } else {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, tv);
            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        }
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Postion : " + position + " Value : " + tv[position], Toast.LENGTH_SHORT).show();
    }
}