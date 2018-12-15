package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import ru.kpfu.itis.photoeditor.filters.Filter;

import java.awt.*;

/**
 * @author Michael Schastlivtsev <rodsher111@gmail.com>
 * Interface characterizes filters that are applied on pixels
 */

public interface PixelApplicableFilter extends Filter {
    Color apply(Color color);
}
