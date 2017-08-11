package com.example.islameldesoky.marvelcomics.Comics.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Creators;

/**
 * Created by islam eldesoky on 10/08/2017.
 */

public class ComicDetailCreatorListAdapter extends RecyclerView.Adapter<ComicDetailCreatorListAdapter.ViewHolder> {
    private Creators creators ;

    public ComicDetailCreatorListAdapter(Creators creators){
        this.creators = creators;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.creator_list_content , parent ,false) ;
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(creators.getItems().get(position).getName());
        holder.role.setText(creators.getItems().get(position).getRole());

    }

    @Override
    public int getItemCount() {
        return creators.getItems().size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        final View mview ;

        final TextView name ;
        final TextView role ;
        Creators creator;

        ViewHolder(View view){
            super(view);
            mview = view  ;


            name  = (TextView) view.findViewById(R.id.creator_name) ;
            role = (TextView) view.findViewById(R.id.creator_role) ;

        }

    }
}
