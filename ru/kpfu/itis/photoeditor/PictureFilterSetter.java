package ru.kpfu.itis.photoeditor;

import ru.kpfu.itis.photoeditor.filters.PercentageVariable;
import ru.kpfu.itis.photoeditor.filters.UnsupportedFilterClassException;
import ru.kpfu.itis.photoeditor.filters.pictureapplicable.PictureApplicableFilter;
import ru.kpfu.itis.photoeditor.filters.Filter;

import java.awt.image.BufferedImage;

/**
 * @author Iskander Musin <musin.iskn@mai.ru>
 * @version 1.4
 * Created for applying picture based filters on a photo. Does not support pixel based filters.
 */
public class PictureFilterSetter implements FilterSetterInterface{
    /**
     *
     * @param image - BufferedImage object which filter should be applied on
     * @param filter - Used filter object
     * @return BufferedImage - filter applied image
     * @throws UnsupportedFilterClassException - Thrown when filter setter uses different (unsupported) type of filter.
     */
    @Override
    public BufferedImage applyFilter(BufferedImage image, Filter filter) throws ClassCastException{
        try {
            return ((PictureApplicableFilter) filter).apply(image);
        }
        catch (ClassCastException e){
            throw new UnsupportedFilterClassException("Given filter is not supported by this filter setter" + e.getMessage());
        }
    }

    /**
     *
     * @param image - BufferedImage object which filter should be applied on
     * @param filter - Used filter object, only filters supporting change degree can be used
     * @param coefficient - describes in what degree filter should be applied
     * @return BufferedImage - filter applied image
     * @throws UnsupportedFilterClassException - Thrown when filter setter uses different (unsupported) type of filter.
     */
    public BufferedImage applyFilter(BufferedImage image, PercentageVariable filter, int coefficient) throws ClassCastException{
        (filter).setPercentage(coefficient);
        try {
            return ((PictureApplicableFilter) filter).apply(image);
        }
        catch (ClassCastException e){
            throw new UnsupportedFilterClassException("Given filter is not supported by this filter setter" + e.getMessage());
        }
    }
}
