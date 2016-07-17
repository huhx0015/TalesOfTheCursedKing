package com.ycorner.totck.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ycorner.totck.R;
import com.ycorner.totck.model.MovieGroup;
import com.ycorner.totck.model.Movies;

import java.util.List;

/**
 * Created by Michael Yoon Huh on 7/15/2016.
 */
public class MovieAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final List<MovieGroup> movieGroups;

    public MovieAdapter(Context context, List<MovieGroup> movieGroups) {
        this.context = context;
        this.movieGroups = movieGroups;
    }

    @Override
    public Movies.Movie getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).movies.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent,
                    false);
        }
        ((TextView) view).setText(getChild(groupPosition, childPosition).name);
        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return getGroup(groupPosition).movies.size();
    }

    @Override
    public MovieGroup getGroup(int groupPosition) {
        return movieGroups.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sample_chooser_inline_header, parent,
                    false);
        }
        ((TextView) view).setText(getGroup(groupPosition).title);
        return view;
    }

    @Override
    public int getGroupCount() {
        return movieGroups.size();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
