package ru.kpfu.itis.ru.photoeditor.filters;

import java.awt.*;

public class RGchanged implements Filter {
    @Override
    public Color apply(Color color) {
        return new Color(color.getRed(),color.getBlue(), color.getGreen());
    }
}
