package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import ru.kpfu.itis.photoeditor.filters.PercentageVariable;

import java.awt.*;
/**
 * The filter regulates brightness of the image
 * @author Vadim Guryanov KFU, ITIS.
 */
public class Lighting implements PixelApplicableFilter, PercentageVariable {

    private int coefficient;
    /**
     * Function that returns the color of pixel with applied filter
     * @param color - color of pixel
     * @return the color of pixel
     * @throws IllegalArgumentException - thrown when coefficient is greater than 100 and less -100 
     */
    public Color apply(Color color) {
        if (coefficient < -100 || coefficient > 100) {
            throw new IllegalArgumentException("Coefficient value out of range.");
        }
        int a = (int) ((double) coefficient / 100 * 255);
        int [] colors = new int[3];
        colors[0] = color.getRed();
        colors[1] = color.getGreen();
        colors[2] = color.getBlue();
        for (int m  = 0; m < 3; m++) {
            if (colors[m] + a < 0) {
                colors[m] = 0;
            } else if (colors[m] + a > 255) {
                colors[m] = 255;
            } else {
                colors[m] = colors[m] + a;
            }
        }
        return new Color(colors[0], colors[1], colors[2]);
    }
    /**
     * Function that allows to set percentage of brightness 
     * @param coefficient - percentage that the filter regulates brightness of the image
     */
    @Override
    public void setPercentage(int coefficient) {
        this.coefficient = coefficient;
    }
}
