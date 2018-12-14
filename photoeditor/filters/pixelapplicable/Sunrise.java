package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

public class Sunrise implements PixelApplicableFilter {
    @Override
    public Color apply(Color color) {
        return new Color(color.getRed(), color.getBlue(), + color.getGreen());
    }
}
