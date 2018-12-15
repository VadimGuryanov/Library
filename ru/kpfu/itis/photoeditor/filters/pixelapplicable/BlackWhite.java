package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

/**
 * BlackWhite filter changes image in black-white color
 * @author Vadim Guryanov KFU, ITIS.
 */

public class BlackWhite implements PixelApplicableFilter {

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
        int grey = (green + red + blue) / 3;
        return new Color(grey, grey, grey);
    }
}