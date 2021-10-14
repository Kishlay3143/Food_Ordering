package com.example.revisionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.revisionapp.Adapters.OrdersAdapter;
import com.example.revisionapp.Models.OrdersModel;
import com.example.revisionapp.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {
    ActivityOrdersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHandler helper=new DBHandler(this);
        ArrayList<OrdersModel> list=helper.getOrders();



        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.ordersRecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.ordersRecyclerview.setLayoutManager(layoutManager);
    }
}