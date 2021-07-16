package com.example.collegeapp.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;
import com.example.collegeapp.fullImage;

import java.util.List;

public class Galleryadapter extends RecyclerView.Adapter<Galleryadapter.GalleryViewAdapter> {

    private Context context;
    private List<String> list;

    public Galleryadapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false);
        return new GalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Galleryadapter.GalleryViewAdapter holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, fullImage.class);
                intent.putExtra("Image",list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GalleryViewAdapter extends RecyclerView.ViewHolder {

        ImageView imageView;
        public GalleryViewAdapter(@NonNull  View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
