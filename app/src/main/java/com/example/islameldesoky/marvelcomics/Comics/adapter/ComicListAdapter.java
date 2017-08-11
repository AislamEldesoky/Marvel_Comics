package com.example.islameldesoky.marvelcomics.Comics.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.islameldesoky.marvelcomics.Comics.ComicDetailActivity;
import com.example.islameldesoky.marvelcomics.Comics.ComicDetailFragment;
import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;

import java.util.List;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicListAdapter extends RecyclerView.Adapter<ComicListAdapter.ViewHolder> {
    private List<Comics> comics;

    public ComicListAdapter(List<Comics> comics) {
        this.comics = comics;
    }

    @Override
    public ComicListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_content, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ComicListAdapter.ViewHolder holder, int position) {
        holder.comic = comics.get(position);
        Glide.with(holder.mview).load(comics.get(holder.getAdapterPosition()).getImages().get(0).getPath()
                + "." + comics.get(holder.getAdapterPosition()).getImages().get(0).getExtension())
                .into(holder.image);
        holder.title.setText(comics.get(position).getTitle());
        holder.mview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle() ;
                arguments.putSerializable(ComicDetailFragment.ARG_COMIC ,holder.comic);
                Context context = v.getContext();
                Intent intent = new Intent(context, ComicDetailActivity.class);
                intent.putExtra(ComicDetailFragment.ARG_COMIC,holder.comic) ;
                intent.putExtra(ComicDetailFragment.ARG_POSITION, holder.getAdapterPosition());
                context.startActivity(intent);
            }
        });

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
