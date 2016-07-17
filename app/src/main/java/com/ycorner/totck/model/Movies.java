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
package com.ycorner.totck.model;

import com.ycorner.totck.R;
import com.ycorner.totck.constants.TOTCKConstants;
import com.google.android.exoplayer.util.Util;
import java.util.Locale;

/**
 * Holds statically defined sample definitions.
 */
/* package */ public class Movies {

  public static class Movie {

    public final String name;
    public final String contentId;
    public final String provider;
    public final String uri;
    public final int type;
    public final int image;

    public Movie(String name, String uri, int type, int image) {
      this(name, name.toLowerCase(Locale.US).replaceAll("\\s", ""), "", uri, type, image);
    }

    public Movie(String name, String contentId, String provider, String uri, int type, int image) {
      this.name = name;
      this.contentId = contentId;
      this.provider = provider;
      this.uri = uri;
      this.type = type;
      this.image = image;
    }
  }

  public static final Movie[] DRAGON_QUEST_VIII = new Movie[] {
          new Movie("Chapter 1: Sight Unseen", TOTCKConstants.BASE_URL + "01%20Sight%20Unseen.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_01_sight_unseen),
          new Movie("Chapter 2: Between Two Fires", TOTCKConstants.BASE_URL + "02%20Between%20Two%20Fires.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_02_between_two_fires),
          new Movie("Chapter 3: Children of the Gods", TOTCKConstants.BASE_URL + "03%20Children%20of%20the%20Gods.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_03_children_of_the_gods),
          new Movie("Chapter 4: Past and Present", TOTCKConstants.BASE_URL + "04%20Past%20and%20Present.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_04_past_and_present),
          new Movie("Chapter 5: Fair Game", TOTCKConstants.BASE_URL + "05%20Fair%20Game.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_05_fair_game),
          new Movie("Chapter 6: Window of Opportunity", TOTCKConstants.BASE_URL + "06%20Window%20of%20Opportunity.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_06_window_of_opportunity),
          new Movie("Chapter 7: Threshold", TOTCKConstants.BASE_URL + "07%20Threshold.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_07_threshold),
          new Movie("Chapter 8: The Ties That Bind", TOTCKConstants.BASE_URL + "08%20The%20Ties%20That%20Bind.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_08_the_ties_that_bind),
          new Movie("Chapter 9: The Enemy Within", TOTCKConstants.BASE_URL + "09%20The%20Enemy%20Within.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_09_the_enemy_within),
          new Movie("Chapter 10: Bloodlines", TOTCKConstants.BASE_URL + "10%20Bloodlines.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_10_bloodlines),
          new Movie("Chapter 11: Maternal Instinct", TOTCKConstants.BASE_URL + "11%20Maternal%20Instinct.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_11_maternal_instinct),
          new Movie("Chapter 12: Rite of Passage", TOTCKConstants.BASE_URL + "12%20Rite%20of%20Passage.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_12_rite_of_passage),
          new Movie("Chapter 13: Enigma", TOTCKConstants.BASE_URL + "13%20Enigma.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_13_enigma),
          new Movie("Chapter 14: Absolute Power", TOTCKConstants.BASE_URL + "14%20Absolute%20Power.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_14_absolute_power),
          new Movie("Chapter 15: Revelations", TOTCKConstants.BASE_URL + "15%20Revelations.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_15_revelations),
          new Movie("Chapter 16: Last Stand", TOTCKConstants.BASE_URL + "16%20Last%20Stand.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_16_last_stand),
          new Movie("Chapter 17: Birthright", TOTCKConstants.BASE_URL + "17%20Birthright.mp4", Util.TYPE_OTHER, R.drawable.totck_chapter_17_birthright),
  };
}
