package ru.kpfu.itis.photoeditor.filters.pixelapplicable;

import ru.kpfu.itis.photoeditor.filters.PercentageVariable;

import java.awt.*;
/**
 * The filter changes image in sephia
 * @author Vadim Guryanov KFU, ITIS.
 */
public class Sephia implements PixelApplicableFilter, PercentageVariable {
    private int coefficient;
    /**
     * Function that returns the color of pixel with applied filter
     * @param color - color of pixel
     * @return the color of pixel
     */
    @Override
    public Color apply(Color color) {
        Color colorBW = (new BlackWhite()).apply(color);
        int coefficient = 25; // число пользователя (%)
        int b = (int) ((double) coefficient / 100 * 255); // перевод в процент для пикселя

        int red = (int) (colorBW.getRed() * 55 / 100);
        int green = (int) (colorBW.getGreen() * 44 / 100);
        int blue = (int) (colorBW.getBlue()*10/100);

        // проверка выхода за границу
        if (red + b > 255) {
            red = 255;
            b = 0;
        }
        if (blue + b > 255) {
            blue = 255;
            b = 0;
        }
        if (green + b > 255) {
            green = 255;
            b = 0;
        }
        return new Color(red + b, green + b, blue + b);
    }

    /**
     * Function that allows to set percentage of the sephia
     * @param coefficient - percentage that the filter regulates sephia of the image
     */
    @Override
    public void setPercentage(int coefficient) {
        this.coefficient = coefficient;
    }
}
