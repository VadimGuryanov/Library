package ru.kpfu.itis.ru.photoeditor.filters;

import java.awt.*;

public class BlackWhite implements Filter {

    @Override
    public Color apply(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int grey = (green + red + blue) / 3;
        return new Color(grey, grey, grey);
    }
}
