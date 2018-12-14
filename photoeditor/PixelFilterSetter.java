package ru.kpfu.itis.photoeditor;

import ru.kpfu.itis.photoeditor.filters.Filter;
import ru.kpfu.itis.photoeditor.filters.PercentageVariable;
import ru.kpfu.itis.photoeditor.filters.pixelapplicable.PixelApplicableFilter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelFilterSetter implements FilterSetterInterface {
    public BufferedImage applyFilter(BufferedImage image, Filter filter) throws ClassCastException{
        for (int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                image.setRGB(i, j, ((PixelApplicableFilter) filter).apply(new Color(image.getRGB(i,j))).getRGB());
            }
        }
        return image;
    }
    public BufferedImage applyFilter(BufferedImage image, PercentageVariable filter, int coefficient){
        ((PercentageVariable) filter).setPercentage(coefficient);
        for (int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                image.setRGB(i, j, ((PixelApplicableFilter)filter).apply(new Color(image.getRGB(i,j))).getRGB());
            }
        }
        return image;
    }
}
