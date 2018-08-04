package com.example.suhanshu.mitra.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.example.suhanshu.mitra.adapter.AdapterClass;
import com.example.suhanshu.mitra.interfaces.OnClickListener;
import com.example.suhanshu.mitra.R;
import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;
import spencerstudios.com.bungeelib.Bungee;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private Toolbar toolbar;
    private int drawsid[]={R.drawable.rohit,R.drawable.sarthak,R.drawable.suraj,R.drawable.udaydhawan,R.drawable.vikas};
    private String names[]={"Rohit","Sarthak","Suraj","Uday","Vikas"};
    private int stringid[]={R.string.rohit,R.string.sarthak,R.string.suraj,R.string.uday,R.string.vikas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        adapterClass = new AdapterClass(this,drawsid,names);
        recyclerView.setLayoutManager(new CardSliderLayoutManager(50,748,12));
        new CardSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapterClass);
    }

    @Override
    public void onClick(int position, CharSequence text) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("images",drawsid[position]);
        intent.putExtra("namesid",names[position]);
        intent.putExtra("stringsid",stringid[position]);
        startActivity(intent);
        Bungee.shrink(this);
    }
}
