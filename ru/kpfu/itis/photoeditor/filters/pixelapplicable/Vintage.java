package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

/**
 *
 * Vintage filter that works only with one pixel step by step
 * @author Schastlivcev Michael KFU, ITIS
 */
public class Vintage implements PixelApplicableFilter {
    /**
     * Function that returns color(pixel) with applied filter color
     * @param pixel - concrete color of the pixel on which filter should be applied
     * @return new color(pixel) of the applied filter
     */
    public Color apply(Color pixel) {
        int r = pixel.getRed() + (pixel.getRed() - 70) + (pixel.getRed() - 100);
        int g = pixel.getGreen() + (pixel.getGreen() - 70) + (pixel.getGreen() - 170);
        int b = pixel.getBlue() + (pixel.getBlue() - 70) + (pixel.getBlue() - 170);
        if (r < 0) r = 0;
        if (r > 255) r = 255;
        if (g < 0) g = 0;
        if (g > 255) g = 255;
        if (b < 0) b = 0;
        if (b > 255) b = 255;
        return new Color(r,g,b);
    }
}