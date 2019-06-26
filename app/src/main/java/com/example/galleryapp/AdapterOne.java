package com.example.galleryapp;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class AdapterOne extends RecyclerView.Adapter<AdapterOne.HolderOne>{
Context c;
ArrayList<String> data;



AdapterOne(Context c,ArrayList<String> data){
    this.c=c;
    this.data=data;
}

    @Override
    public HolderOne onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v= LayoutInflater.from(c).inflate(R.layout.resource,viewGroup,false);
    HolderOne obj=new HolderOne(v);
    return obj;

    }

    @Override
    public void onBindViewHolder(@NonNull HolderOne holderOne, int i) {
//       Uri uri = Uri.parse(data.get(i));
       Uri uri = Uri.fromFile(new File(data.get(i)));
        Picasso.with(c).load(uri).into(holderOne.iv);
    }


    public int getItemCount() {
        return data.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{

ImageView iv;
    public HolderOne(@NonNull View itemView) {
        super(itemView);
        iv=itemView.findViewById(R.id.image);
    }
}


}
