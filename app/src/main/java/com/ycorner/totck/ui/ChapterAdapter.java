package com.ycorner.totck.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ycorner.totck.R;
import com.ycorner.totck.activities.PlayerActivity;
import com.ycorner.totck.model.MovieGroup;
import com.ycorner.totck.model.Movies;

import java.util.List;

/**
 * Created by Michael Yoon Huh on 7/4/2016.
 */
public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>  {

    private Context context;
    private List<MovieGroup> chapterGroup;

    public ChapterAdapter(List<MovieGroup> chapterGroup, Context context) {
        this.chapterGroup = chapterGroup;
        this.context = context;
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_chapter, parent, false);

        ChapterViewHolder viewHolder = new ChapterViewHolder(view, new ChapterViewHolder.OnViewHolderClickListener() {
            @Override
            public void onChapterClick(View caller, int position) {
                launchPlayerIntent(chapterGroup.get(0).movies.get(position));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        holder.chapterTextView.setText(chapterGroup.get(0).movies.get(position).name);
        holder.chapterTextView.setShadowLayer(4, 2, 2, Color.BLACK);

        Glide.with(context)
                .load(chapterGroup.get(0).movies.get(position).image)
                .asBitmap()
                .into(holder.chapterImageView);
    }

    @Override
    public int getItemCount() {
        if (chapterGroup != null) {
            return chapterGroup.get(0).movies.size();
        } else {
            return 0;
        }
    }

    /** INTENT METHODS _________________________________________________________________________ **/

    private void launchPlayerIntent(Movies.Movie movie) {
        Intent mpdIntent = new Intent(context, PlayerActivity.class)
                .setData(Uri.parse(movie.uri))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, movie.contentId)
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, movie.type)
                .putExtra(PlayerActivity.PROVIDER_EXTRA, movie.provider);
        context.startActivity(mpdIntent);
    }

    /** SUBCLASSES _____________________________________________________________________________ **/

    public static class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayout chapterLayout;
        private ImageView chapterImageView;
        private TextView chapterTextView;

        public OnViewHolderClickListener viewHolderClickListener;

        ChapterViewHolder(View itemView, OnViewHolderClickListener listener) {
            super(itemView);

            chapterLayout = (LinearLayout) itemView.findViewById(R.id.adapter_chapter_layout);
            chapterImageView = (ImageView) itemView.findViewById(R.id.adapter_chapter_image);
            chapterTextView = (TextView) itemView.findViewById(R.id.adapter_chapter_text);

            if (listener != null) {
                viewHolderClickListener = listener;
                chapterLayout.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            int itemPos = getAdapterPosition();
            viewHolderClickListener.onChapterClick(v, itemPos);
        }

        public interface OnViewHolderClickListener {
            void onChapterClick(View caller, int position);
        }
    }
}