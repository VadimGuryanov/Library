package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import java.awt.*;

public class Negative implements PixelApplicableFilter {
    @Override
    public Color apply(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int inversedGrey = 255 - (red + green + blue) / 3;
        return new Color(inversedGrey, inversedGrey, inversedGrey);
    }
}
