package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;
/**
 * The filter changes image in light blue color
 * @author Vadim Guryanov KFU, ITIS.
 */
public class Snow implements PixelApplicableFilter {
    /**
     * Function that returns the color of pixel with applied filter
     * @param color - color of pixel
     * @return the color of pixel
     */
    @Override
    public Color apply(Color color) {
        int red =  color.getRed();
        int green = (color.getGreen());
        int blue = color.getBlue() + 40;
        if (blue > 255) {
            blue = 255;
        }
        else  if (color.getBlue() + 20 < 0) {
            blue = 0;
        }

        return new Color(red, green, blue);
    }
}
