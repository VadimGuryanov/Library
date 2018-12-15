package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;
/**
 * Sunrise filter create the morning atmosphere on image
 * @author Iscander Musin KFU, ITIS.
 */
public class Sunrise implements PixelApplicableFilter {
	/**
     * Function that returns the color of pixel with applied filter
     * @param color - color of pixel
     * @return the color of pixel
     */
    @Override
    public Color apply(Color color) {
        return new Color(color.getRed(), color.getBlue(), + color.getGreen());
    }
}
