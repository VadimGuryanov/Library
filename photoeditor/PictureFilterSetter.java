package ru.kpfu.itis.photoeditor;

import ru.kpfu.itis.photoeditor.filters.PercentageVariable;
import ru.kpfu.itis.photoeditor.filters.pictureapplicable.PictureApplicableFilter;
import ru.kpfu.itis.photoeditor.filters.Filter;

import java.awt.image.BufferedImage;

public class PictureFilterSetter implements FilterSetterInterface{
    @Override
    public BufferedImage applyFilter(BufferedImage image, Filter filter) throws ClassCastException{
        filter = (PictureApplicableFilter) filter;
        return ((PictureApplicableFilter) filter).apply(image);
    }
    public BufferedImage applyFilter(BufferedImage image, PercentageVariable filter, int coefficient) throws ClassCastException{
        ((PercentageVariable) filter).setPercentage(coefficient);
        return ((PictureApplicableFilter) filter).apply(image);
    }
}
