package com.ilmare.swipedismisslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ilmare.swipedismisslistview.View.SwipeDismissListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeDismissListView swipeDismissListView;
    private ArrayAdapter<String> adapter;
    private List<String> dataSourceList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {

        swipeDismissListView = (SwipeDismissListView) findViewById(R.id.SwipeDismissListView);
        for (int i = 0; i < 20; i++) {
            dataSourceList.add("滑动删除" + i);
        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, dataSourceList);

        swipeDismissListView.setAdapter(adapter);

        swipeDismissListView.setOnDismissCallback(new SwipeDismissListView.OnDismissCallback() {

            @Override
            public void onDismiss(int dismissPosition) {
                adapter.remove(adapter.getItem(dismissPosition));
            }
        });


        swipeDismissListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
