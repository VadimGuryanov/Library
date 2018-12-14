package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

public class Snow implements PixelApplicableFilter {

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
