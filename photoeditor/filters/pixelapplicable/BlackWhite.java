package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

public class BlackWhite implements PixelApplicableFilter {

    @Override
    public Color apply(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int grey = (green + red + blue) / 3;
        return new Color(grey, grey, grey);
    }
}
