package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import ru.kpfu.itis.photoeditor.filters.Filter;

import java.awt.*;

public interface PixelApplicableFilter extends Filter {
    Color apply(Color color);
}
