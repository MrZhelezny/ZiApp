package com.zhelezny.ziapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zhelezny.ziapp.model.Animal;
import com.zhelezny.ziapp.view.MainInterface;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private Context mContext;
    private List<Animal> mAnimals;
    private MainInterface mInterface;

    public MainAdapter(Context context, List<Animal> animals, MainInterface mainInterface) {
        mContext = context;
        mAnimals = animals;
        mInterface = mainInterface;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_main, parent, false);
        final MainViewHolder viewHolder = new MainViewHolder(view);

        viewHolder.linearLayout.setOnClickListener(v -> showDetailAnimal(viewHolder));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Animal animal = mAnimals.get(position);
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#F0F8FF"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
        }

        holder.textView.setText(animal.getTitle());
        holder.mainInterface = mInterface;
        Picasso.get().load(animal.getImage())/*.transform(new CircularTransformation(2))*/.into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    private void showDetailAnimal(RecyclerView.ViewHolder viewHolder) {
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_animal);
        ImageView imageView = dialog.findViewById(R.id.iv_detail);
        TextView textView = dialog.findViewById(R.id.tv_detail);
        textView.setText(mAnimals.get(viewHolder.getAdapterPosition()).getTitle());
        Picasso.get().load(mAnimals.get(viewHolder.getAdapterPosition()).getImage()).into(imageView);
        dialog.show();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;
        MainInterface mainInterface;

        public MainViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.linerLayoutItem);
        }
    }
}
