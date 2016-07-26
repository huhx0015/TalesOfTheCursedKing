package com.ycorner.totck.activities;

import com.ycorner.totck.display.TOTCKDisplayUtils;
import com.ycorner.totck.ui.ChapterAdapter;
import com.ycorner.totck.R;
import com.ycorner.totck.model.MovieGroup;
import com.ycorner.totck.model.Movies;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * An activity for selecting from a number of movies.
 */
public class ChapterActivity extends AppCompatActivity {

    private List<MovieGroup> chapterGroup = new ArrayList<>();

    @BindView(R.id.activity_chapter_recycler_view) RecyclerView chapterRecyclerView;
    @BindView(R.id.activity_chapter_background) ImageView chapterBackground;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        ButterKnife.bind(this);

        initChapterList();
        initRecyclerView();
    }

    private void initChapterList() {

        // Builds the list of movie chapters
        chapterGroup = new ArrayList<>();
        MovieGroup group = new MovieGroup("Dragon Quest VIII");
        group.addAll(Movies.DRAGON_QUEST_VIII);
        chapterGroup.add(group);
    }

    /** RECYCLER VIEW METHODS __________________________________________________________________ **/

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Sets the orientation of the RecyclerView, based on the current display orientation.
        // PORTRAIT:
        if (TOTCKDisplayUtils.getOrientation(this) == 0) {
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        }

        // LANDSCAPE:
        else {
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }

        chapterRecyclerView.setLayoutManager(layoutManager);
        ChapterAdapter chapterAdapter = new ChapterAdapter(chapterGroup, this);
        chapterRecyclerView.setAdapter(chapterAdapter);
    }
}
