package com.example.islameldesoky.marvelcomics.savedcomics.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;

import java.util.List;

/**
 * Created by islam eldesoky on 11/08/2017.
 */

public class SavedComicsAdapter extends RecyclerView.Adapter<SavedComicsAdapter.ViewHolder> {
    private List<Comics> comics;

    public SavedComicsAdapter(List<Comics> comics) {
        this.comics = comics;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SavedComicsAdapter.ViewHolder holder, int position) {
        holder.comic = comics.get(position);
        Glide.with(holder.mview).load(comics.get(holder.getAdapterPosition()).getImages().get(0).getPath()
                + "." + comics.get(holder.getAdapterPosition()).getImages().get(0).getExtension())
                .into(holder.image);
        holder.title.setText(comics.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public void setData(List<Comics> comics) {
        this.comics = comics;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mview;
        final TextView title;
        final ImageView image;
        Comics comic;

        ViewHolder(View view) {
            super(view);
            mview = view;
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }
}
