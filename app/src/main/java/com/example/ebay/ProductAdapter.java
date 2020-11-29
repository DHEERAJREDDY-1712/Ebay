package com.example.ebay;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter <ProductAdapter.MyViewHolder>{
    Activity activity;
    String userEmail;
    ArrayList<Product> arrayList;
    public ProductAdapter(Activity activity, ArrayList<Product> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(activity.getLayoutInflater().inflate(R.layout.product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.MyViewHolder holder, int position) {

        holder.amount.setText(arrayList.get(position).getAmount());
        holder.name.setText(arrayList.get(position).getName());
        Glide.with(activity).load(arrayList.get(position).getImageurl()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity,ProductDetailsActivity.class)
                .putExtra("product",arrayList.get(holder.getAdapterPosition())));

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,amount,buynow;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
        }
    }


}
