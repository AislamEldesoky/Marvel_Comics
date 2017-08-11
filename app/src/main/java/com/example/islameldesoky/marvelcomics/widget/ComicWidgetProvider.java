package com.example.islameldesoky.marvelcomics.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;
import com.example.islameldesoky.marvelcomics.savedcomics.SavedComicsActivity;

/**
 * Created by islam eldesoky on 10/08/2017.
 */

public class ComicWidgetProvider extends AppWidgetProvider {

    public static final String ACTION_TOAST = "com.bakingDesoky.ui.widgets.ACTION_TOAST";
    private Comics comic;



    public ComicWidgetProvider() {
        super();


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.comic_widget_list);
        Intent intent = new Intent(context, ComicWidgetService.class);
        views.setRemoteAdapter(
                R.id.widget_list_view,
                intent);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

        final Intent OnItemClickintent = new Intent(context, SavedComicsActivity.class);
        OnItemClickintent.setAction(ACTION_TOAST);
        OnItemClickintent.setData(Uri.parse(OnItemClickintent
                .toUri(Intent.URI_INTENT_SCHEME)));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, OnItemClickintent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setPendingIntentTemplate(R.id.widget_list_view,
                pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    public static void updateIngredientWidgets(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}

