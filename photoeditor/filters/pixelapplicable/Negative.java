package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;
/**
 * The filter changes image in negative
 * @author Iscander Musin KFU, ITIS.
 */
public class Negative implements PixelApplicableFilter {
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
        int inversedGrey = 255 - (red + green + blue) / 3;
        return new Color(inversedGrey, inversedGrey, inversedGrey);
    }
}
