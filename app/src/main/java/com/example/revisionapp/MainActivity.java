package com.example.revisionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.revisionapp.Adapters.MainAdapter;
import com.example.revisionapp.Models.MainModel;
import com.example.revisionapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.pizza,"Pizza","6","This is our special pizza"));
        list.add(new MainModel(R.drawable.fish,"Fish","10","This is our special fish"));
        list.add(new MainModel(R.drawable.burger,"Burger","5","This is our special burger"));
        list.add(new MainModel(R.drawable.chicken,"Chicken","15","This is our special chicken"));

        list.add(new MainModel(R.drawable.pizza,"Pizza","6","This is our special pizza"));
        list.add(new MainModel(R.drawable.fish,"Fish","10","This is our special fish"));
        list.add(new MainModel(R.drawable.burger,"Burger","5","This is our special burger"));
        list.add(new MainModel(R.drawable.chicken,"Chicken","15","This is our special chicken"));


        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrdersActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}