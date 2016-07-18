package com.ycorner.totck.display;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.Display;

/** -----------------------------------------------------------------------------------------------
 *  [TOTCKDisplayUtils] CLASS
 *  PROGRAMMER: Huh X0015
 *  DESCRIPTION: TOTCKDisplayUtils class is a class that contains functions that are used to
 *  determine the screen attributes of the Android device.
 *  -----------------------------------------------------------------------------------------------
 */

public class TOTCKDisplayUtils {

    /** DISPLAY FUNCTIONALITY ___________________________________________________________________**/

    // getDisplaySize(): Used for retrieving the display size of the device.
    public static int getDisplaySize(Point resolution, int currentOrientation) {

        int size = 0;

        // PORTRAIT MODE: Determines the display size from the resolution.x value.
        if (currentOrientation == 0) { size = resolution.x; }

        // LANDSCAPE MODE: Determines the display size from the resolution.y value.
        else if (currentOrientation == 1) { size = resolution.y; }

        return size;
    }

    // getOrientation(): Retrieves the device's current orientation.
    public static int getOrientation(Context context) {

        int currentOrientation = 0; // Return value for

        // Retrieves the device's current screen orientation.
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            currentOrientation = 0;
        }

        else if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            currentOrientation = 1;
        }

        return currentOrientation;
    }

    // getResolution(): Retrieves the device's screen resolution (width and height).
    public static Point getResolution(Display display) {
        Point displayDimen = new Point(); // Used for determining the device's display resolution.
        display.getSize(displayDimen);
        return displayDimen;
    }
}
