package com.erns.canvaspre.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.erns.canvaspre.R;
import com.erns.canvaspre.model.ent.PictureEntity;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder> {

    private final List<PictureEntity> pictureList;

    // Constructor
    public PictureAdapter(List<PictureEntity> pictureList) {
        this.pictureList = pictureList;
    }

    // ViewHolder para cada ítem
    public static class PictureViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView authorTextView;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
        }
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_picture, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        PictureEntity picture = pictureList.get(position);
        holder.titleTextView.setText(picture.title);
        holder.authorTextView.setText(picture.author);

        // De momento dejamos el ImageView vacío
        //holder.imageView.setImageResource(0);
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }
}