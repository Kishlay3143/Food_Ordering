package com.example.revisionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.revisionapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHandler helper=new DBHandler(this);
        if (getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.datailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.textView2.setText(name);
            binding.detailDescription.setText(description);


            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(binding.nameBox.getText().toString(), binding.phoneBox.getText().toString(),
                            price, Integer.parseInt(binding.quantity.getText().toString()), image, description, name);
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Success!!!!!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error!!!!!", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            // This else block was left empty initially
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor=helper.getOrderById(id);
            int image=cursor.getInt(5);
            binding.datailImage.setImageResource(cursor.getInt(5));
            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
            binding.textView2.setText(cursor.getString(7));
            binding.detailDescription.setText(cursor.getString(6));

            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Method calling (updateOrder)
                    boolean isUpdated = helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            1,
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.textView2.getText().toString(), // Actually this is the foodName from the detail activity.
                            id
                    );
                    if (isUpdated){
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}