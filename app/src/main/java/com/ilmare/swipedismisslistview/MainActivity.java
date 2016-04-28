package com.ilmare.swipedismisslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.ilmare.swipedismisslistview.View.SwipeDismissListView;
import com.ilmare.swipedismisslistview.holder.FileItemHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeDismissListView swipeDismissListView;
    private MyFloderAdapter adapter;
    private List<String> dataSourceList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();

    }


    private void init() {

        swipeDismissListView = (SwipeDismissListView) findViewById(R.id.SwipeDismissListView);
        for (int i = 0; i < 30; i++) {
            dataSourceList.add(i+"");
        }



        swipeDismissListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, adapter.getItem(position)+"", Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new MyFloderAdapter(dataSourceList);

        swipeDismissListView.setAdapter(adapter);


        swipeDismissListView.setOnDismissCallback(new SwipeDismissListView.OnDismissCallback() {

            @Override
            public void onDismiss(int dismissPosition) {
                dataSourceList.remove(dismissPosition);
                adapter.notifyDataSetChanged();

            }

        });


    }



    //设置适配器
    private class MyFloderAdapter extends BaseAdapter {

        private List<String> data;

        public MyFloderAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FileItemHolder holder = null;
            if (convertView == null) {
                holder = new FileItemHolder(getLayoutInflater(), parent);
                convertView = holder.getView();
                convertView.setTag(holder);
            } else {
                holder = (FileItemHolder) convertView.getTag();
            }

            holder.getIvIcon().setImageResource(R.mipmap.directory_icon); //设置图标
            holder.getTvName().setText("80122" + data.get(position));   //设置文件夹名称
            holder.getTvTime().setText(new Date().toString());   //设置事件

//          holder.getTvSize().setText();   //设置文件夹大小
            return convertView;
        }

    }


}
