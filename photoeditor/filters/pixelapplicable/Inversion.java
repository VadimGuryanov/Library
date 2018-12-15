package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

/**
 * The filter inverses image
 * @author Iscander Musin KFU, ITIS.
 */

public class Inversion implements PixelApplicableFilter {
	/**
     * Function that returns the color of pixel with applied filter
     * @param color - color of pixel
     * @return the color of pixel
     */
    @Override
    public Color apply(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return new Color(255 - red, 255 - green, 255 - blue);
    }
}
