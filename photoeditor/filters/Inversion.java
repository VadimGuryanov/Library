package ru.kpfu.itis.ru.photoeditor.filters;

import java.awt.*;

public class Inversion implements Filter {
    @Override
    public Color apply(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return new Color(255 - red, 255 - green, 255 - blue);
    }
}
