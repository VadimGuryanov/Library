package ru.kpfu.itis.photoeditor;

import ru.kpfu.itis.photoeditor.filters.Filter;
import ru.kpfu.itis.photoeditor.filters.PercentageVariable;
import ru.kpfu.itis.photoeditor.filters.UnsupportedFilterClassException;

import java.awt.image.BufferedImage;

/**
 * @author Iskander Musin <musin.iskn@mail.ru>
 * @version 1.4
 * Filter setting behavior interface
 */
public interface FilterSetterInterface {
    /**
     *
     * @param image - Buffered image object representing original picture
     * @param filter - Filter object that should be applied
     * @return BufferedImage - changed image
     * @throws UnsupportedFilterClassException - thrown when different type of filter is used
     */
    BufferedImage applyFilter(BufferedImage image, Filter filter) throws UnsupportedFilterClassException;
    BufferedImage applyFilter(BufferedImage image, PercentageVariable filter, int coefficient) throws UnsupportedFilterClassException;

}
