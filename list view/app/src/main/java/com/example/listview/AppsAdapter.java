package com.example.listview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppsAdapter extends ArrayAdapter<ApplicationInfo> {

    private final Context context;
    private final List<ApplicationInfo> apps;
    private final int resourceLayout;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resourceLayout, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imagemApp);
        TextView textView   = convertView.findViewById(R.id.textApp);

        ApplicationInfo app = apps.get(position);
        imageView.setImageDrawable(app.loadIcon(context.getPackageManager()));
        textView.setText(app.loadLabel(context.getPackageManager()));
        return convertView;
    }

    public AppsAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);

        this.context        = context;
        this.apps           = objects;
        this.resourceLayout = resource;
    }
}