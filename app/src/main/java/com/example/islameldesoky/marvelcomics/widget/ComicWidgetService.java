package com.example.islameldesoky.marvelcomics.widget;

/**
 * Created by islam eldesoky on 10/08/2017.
 */
/*
public class ComicWidgetService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new ComicWidgetListFactory(this.getApplicationContext(), intent);
    }


    public class ComicWidgetListFactory implements RemoteViewsService.RemoteViewsFactory {
        Context mContext;
        Comics comic ;
        List<Comics> comics ;
        ComicListActivity activitys;
        int size;


        ComicWidgetListFactory(Context applicationContext, Intent intent) {
            this.mContext = applicationContext;

        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return comics.size();
        }

        @Override
        public RemoteViews getViewAt(int position) {

            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.comic_widget_layout);

            if (position < comics.size()) {
                views.setTextViewText(R.id.comic_widget_title, comics.get(position).getTitle());


                Intent fillInIntent = new Intent();
                fillInIntent.setAction(ComicWidgetProvider.ACTION_TOAST);
                Bundle extras = new Bundle();
                extras.putString(ComicDetailFragment.ARG_COMIC, comics.get(position).getTitle());

                fillInIntent.putExtras(extras);
                views.setOnClickFillInIntent(R.id.comic_widget_title, fillInIntent);

                return views;
            } else {
                RemoteViews views1 = new RemoteViews(mContext.getPackageName(), R.layout.comic_widget_layout);
                views1.setViewVisibility(R.id.llrootview, View.GONE);
                return views1;
            }
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
*/