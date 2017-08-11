package com.example.islameldesoky.marvelcomics.Comics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.islameldesoky.marvelcomics.Comics.adapter.ComicDetailCharacterListAdapter;
import com.example.islameldesoky.marvelcomics.Comics.adapter.ComicDetailCreatorListAdapter;
import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;

import java.util.List;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicDetailFragment extends Fragment {
    public static final String ARG_POSITION = "position" ;
    public static final String ARG_COMIC = "comic" ;
    private String key ;
    private int position ;
    private RecyclerView recyclerViewCharacters ;
    private RecyclerView recyclerViewCreators ;
    private Comics comic ;
    private TextView price ;
    private TextView date ;
    private TextView title ;
    List<Comics> comics ;
    private TextView creators_list ;
    private TextView characters_list ;
    private ImageView image ;
    private TextView description ;
    private Bundle mBundle ;
    private ComicDetailCharacterListAdapter comicDetailCharacterListAdapter ;
    private ComicDetailCreatorListAdapter comicDetailCreatorListAdapter ;

    public ComicDetailFragment(){
    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments() == null ? getActivity().getIntent().getExtras() : getArguments();

        position = getArguments() == null ?
                getActivity().getIntent().getIntExtra(ARG_POSITION, 1) :
                getArguments().getInt(ARG_POSITION);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_comics_detail, container , false) ;

        if (mBundle!=null){
            comic = (Comics) mBundle.getSerializable(ComicDetailFragment.ARG_COMIC) ;
            ((TextView) rootView.findViewById(R.id.Price)).setText(comic.getPrice().get(0).getPrice());

            title = (TextView) rootView.findViewById(R.id.title_detail);
            title.setText(comic.getTitle());

            description = (TextView) rootView.findViewById(R.id.comic_description) ;
            description.setText(comic.getDescription());
            date = (TextView) rootView.findViewById(R.id.date) ;
            date.setText(comic.getDates().get(0).getDate());
            image = (ImageView) rootView.findViewById(R.id.comic_poster) ;
            Glide.with(rootView).load(comic.getImages()
                    .get(0).getPath()+ "." + comic.getImages().get(0)
                    .getExtension()).into(image) ;
            recyclerViewCharacters = (RecyclerView) rootView.findViewById(R.id.characters_list);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(rootView.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false);
            RecyclerView.LayoutManager manager2 = new LinearLayoutManager(rootView.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false);
            recyclerViewCharacters.setLayoutManager(manager);

            comicDetailCharacterListAdapter = new ComicDetailCharacterListAdapter(comic.getCharacters());
            recyclerViewCharacters.setAdapter(comicDetailCharacterListAdapter);

            recyclerViewCreators = (RecyclerView) rootView.findViewById(R.id.creators_list) ;
            recyclerViewCreators.setLayoutManager(manager2);

            comicDetailCreatorListAdapter = new ComicDetailCreatorListAdapter(comic.getCreators());
            recyclerViewCreators.setAdapter(comicDetailCreatorListAdapter);

        }

        return rootView ;
    }
}