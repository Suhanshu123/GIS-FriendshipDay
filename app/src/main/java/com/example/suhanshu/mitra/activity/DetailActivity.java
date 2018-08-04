package com.example.suhanshu.mitra.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suhanshu.mitra.R;

import spencerstudios.com.bungeelib.Bungee;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private String name;
    private int descriptId;
    private int ids;
    private TextView title;
    private TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.profile_image);
        title = findViewById(R.id.title_view);
        descriptionView = findViewById(R.id.descript_view);
        Intent intent = getIntent();
        ids=intent.getExtras().getInt("images");
        name=intent.getExtras().getString("namesid");
        descriptId=intent.getExtras().getInt("stringsid");
        title.setText(name);
        descriptionView.setText(getString(descriptId));
        imageView.setImageResource(ids);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.zoom(this); //fire the slide left animation
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            Bungee.zoom(this); //fire the slide left animation
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
