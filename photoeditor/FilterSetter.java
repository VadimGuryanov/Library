package ru.kpfu.itis.ru.photoeditor;

import ru.kpfu.itis.ru.photoeditor.filters.Filter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilterSetter {
    public static BufferedImage applyFilter(BufferedImage image, Filter filter){
        for (int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                image.setRGB(i, j, filter.apply(new Color(image.getRGB(i,j))).getRGB());
            }
        }
        return image;
    }
}
