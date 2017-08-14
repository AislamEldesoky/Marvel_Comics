package com.example.islameldesoky.marvelcomics.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.islameldesoky.marvelcomics.Comics.ComicListActivity;
import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;
import com.example.islameldesoky.marvelcomics.savedcomics.SavedComicsActivity;
import com.example.islameldesoky.marvelcomics.utils.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islam eldesoky on 10/08/2017.
 */

public class ComicWidgetService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new ComicWidgetListFactory(this.getApplicationContext(), intent);
    }


    public class ComicWidgetListFactory implements RemoteViewsService.RemoteViewsFactory {
        Context mContext;
        Comics comic;
        List<Comics> comics;
        ComicListActivity activitys;
        int size;


        ComicWidgetListFactory(Context applicationContext, Intent intent) {
            this.mContext = applicationContext;

            if (App.getInstance().getComics() == null) {
                comics = new ArrayList<>();
            } else {
                comics = App.getInstance().getComics();
            }
        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {
            if (App.getInstance().getComics() == null) {
                comics = new ArrayList<>();
            } else {
                comics = App.getInstance().getComics();
            }
        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return comics == null ? 0 : comics.size();
        }

        @Override
        public RemoteViews getViewAt(int position) {

            comics = App.getInstance().getComics();
            comic = comics.get(position) ;
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.comic_widget_layout);

            views.setTextViewText(R.id.comic_widget_title, comic.getTitle());


            Intent fillInIntent = new Intent();
            fillInIntent.setAction(ComicWidgetProvider.ACTION_TOAST);
            Bundle extras = new Bundle();
            extras.putString(SavedComicsActivity.ARG_COMIC, comic.getTitle());

            fillInIntent.putExtras(extras);
            views.setOnClickFillInIntent(R.id.comic_widget_title, fillInIntent);
            return views;

        }


        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
