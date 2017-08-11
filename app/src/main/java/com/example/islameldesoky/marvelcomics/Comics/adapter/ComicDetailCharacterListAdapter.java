package com.example.islameldesoky.marvelcomics.Comics.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Characters;

/**
 * Created by islam eldesoky on 10/08/2017.
 */

public class ComicDetailCharacterListAdapter extends RecyclerView.Adapter<ComicDetailCharacterListAdapter.ViewHolder> {
    private Characters characters ;
    public ComicDetailCharacterListAdapter (Characters characters){
        this.characters = characters;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_content , parent ,false) ;
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(characters.getItems().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return characters.getItems().size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        final View mview ;

        final TextView name ;
        Characters character;

        ViewHolder(View view){
            super(view);
            mview = view  ;


            name  = (TextView) view.findViewById(R.id.character_name) ;

        }

    }
}
