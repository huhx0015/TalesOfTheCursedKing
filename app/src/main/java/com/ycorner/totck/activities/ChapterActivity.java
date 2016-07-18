/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

//        ExpandableListView sampleList = (ExpandableListView) findViewById(R.id.sample_list);
//        sampleList.setAdapter(new MovieAdapter(this, movieGroups));
//        sampleList.setOnChildClickListener(new OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition,
//                                        int childPosition, long id) {
//                onSampleSelected(movieGroups.get(groupPosition).movies.get(childPosition));
//                return true;
//            }
//        });
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
