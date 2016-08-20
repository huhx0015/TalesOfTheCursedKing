package com.ycorner.totck.data;

import android.content.Context;
import android.content.SharedPreferences;

/** -----------------------------------------------------------------------------------------------
 *  [PreferencesUtil] CLASS
 *  DESCRIPTION: PreferencesUtil is a class that contains functionality that pertains to the use and
 *  manipulation of shared preferences data.
 *  -----------------------------------------------------------------------------------------------
 */

public class PreferencesUtil {

    /** SHARED PREFERENCES FUNCTIONALITY _______________________________________________________ **/

    // initializePreferences(): Initializes and returns the SharedPreferences object.
    public static SharedPreferences initializePreferences(String prefType, Context context) {
        return context.getSharedPreferences(prefType, Context.MODE_PRIVATE);
    }

    /** GET PREFERENCES FUNCTIONALITY __________________________________________________________ **/

    // getPreviousPosition(): Retrieves the previous movie position value from SharedPreferences.
    public static int getPreviousPosition(String movieName, SharedPreferences preferences) {
        return preferences.getInt(movieName, 0);
    }

    /** SET PREFERENCES FUNCTIONALITY __________________________________________________________ **/

    // setSavedPosition(): Saves the movie position value to SharedPreferences.
    public static void setSavedPosition(String movieName, int position, SharedPreferences preferences) {

        // Prepares the SharedPreferences object for editing.
        SharedPreferences.Editor prefEdit = preferences.edit();

        prefEdit.putInt(movieName, position); // Sets the movie position to preferences.
        prefEdit.apply(); // Applies the changes to SharedPreferences.
    }
}