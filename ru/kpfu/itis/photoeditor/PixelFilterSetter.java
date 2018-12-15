package ru.kpfu.itis.photoeditor;

import ru.kpfu.itis.photoeditor.filters.Filter;
import ru.kpfu.itis.photoeditor.filters.PercentageVariable;
import ru.kpfu.itis.photoeditor.filters.UnsupportedFilterClassException;
import ru.kpfu.itis.photoeditor.filters.pixelapplicable.PixelApplicableFilter;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * @author Michael Schastlivtsev <rodsher111@gmail.com>
 * @version 1.4
 * Created for applying picture based filters on a photo. Does not support picture based filters.
 */
public class PixelFilterSetter implements FilterSetterInterface {
    /**
     *
     * @param image - BufferedImage object representing original picture
     * @param filter - Applied filter
     * @return BufferedImage - changed picture
     */
    public BufferedImage applyFilter(BufferedImage image, Filter filter) throws ClassCastException{
        for (int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++) {
                try {
                    image.setRGB(i, j, ((PixelApplicableFilter) filter).apply(new Color(image.getRGB(i, j))).getRGB());
                }
                catch (ClassCastException e){
                    throw new UnsupportedFilterClassException("Given filter is not supported by this filter setter" + e.getMessage());
                }
            }

        }
        return image;
    }

    /**
     *
     * @param image - BufferedImage object representing original picture
     * @param filter - Applied filter
     * @param coefficient - Change degree
     * @return BufferedImage - changed picture
     */
    public BufferedImage applyFilter(BufferedImage image, PercentageVariable filter, int coefficient){
        filter.setPercentage(coefficient);
        for (int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                try {
                    image.setRGB(i, j, ((PixelApplicableFilter) filter).apply(new Color(image.getRGB(i, j))).getRGB());
                }
                catch (ClassCastException e){
                    throw new UnsupportedFilterClassException("Given filter is not supported by this filter setter." + e.getMessage());
                }
            }
        }
        return image;
    }
}
