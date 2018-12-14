package ru.kpfu.itis.photoeditor;

import ru.kpfu.itis.photoeditor.filters.Filter;
import ru.kpfu.itis.photoeditor.filters.PercentageVariable;

import java.awt.image.BufferedImage;

public interface FilterSetterInterface {
    BufferedImage applyFilter(BufferedImage image, Filter filter) throws ClassCastException;
    BufferedImage applyFilter(BufferedImage image, PercentageVariable filter, int coefficient) throws ClassCastException;

}
