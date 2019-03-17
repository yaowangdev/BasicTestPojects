package com.appdev.basic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_recyclerView);
        initData();
        mAdapter= new MyAdapter(strings);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, SoftInputModeActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });
    }

    private void initData() {
        strings.add("键盘测试1");
    }


    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        List<String> list;
        LayoutInflater inflater;
        OnItemClickListener listener;

        public MyAdapter(List<String> list) {
            this.list = list;
            inflater = LayoutInflater.from(MainActivity.this);
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = inflater.inflate(R.layout.layout_main_item, viewGroup, false);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
            myViewHolder.textView.setText(list.get(i));
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onItemClick(i);
                    }
                }
            });
        }


        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }

    interface OnItemClickListener{
        void onItemClick(int i);
    }

}
