package ru.kpfu.itis.photoeditor.filters.pictureapplicable;

import ru.kpfu.itis.photoeditor.filters.Filter;

import java.awt.image.BufferedImage;
/**
 * @author Michael Schastlivtsev <rodsher111@gmail.com>
 * Interface characterizes filters that are applied on pictures
 */
public interface PictureApplicableFilter extends Filter {
    BufferedImage apply(BufferedImage image);
}
