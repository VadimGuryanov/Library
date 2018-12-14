package ru.kpfu.itis.photoeditor.filters.pictureapplicable;

import ru.kpfu.itis.photoeditor.filters.Filter;

import java.awt.image.BufferedImage;

public interface PictureApplicableFilter extends Filter {
    BufferedImage apply(BufferedImage image);
}
