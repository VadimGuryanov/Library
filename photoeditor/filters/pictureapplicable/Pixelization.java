package ru.kpfu.itis.photoeditor.filters.pictureapplicable;

import ru.kpfu.itis.photoeditor.filters.PercentageVariable;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * Pixelization filter with changeable size of pixel squares that affects on whole image.
 * @author Schastlivcev Michael KFU, ITIS.
 */
public class Pixelization implements PictureApplicableFilter, PercentageVariable {
    /** Field of the size in pixels of the pixel square.*/
    private int pixelSize = 1;

    /**
     * Function which returns an image with applied filter
     * @param image - image on which you want to apply the filter
     * @return modified image
     * @throws IllegalArgumentException - thrown when size of the square is less than 1 or greater than size of the image
     */
    public BufferedImage apply(BufferedImage image) throws IllegalArgumentException {
        int x = 0, y = 0;
        if(pixelSize <= 0 || pixelSize >= image.getWidth() || pixelSize >= image.getHeight()) {
            throw new IllegalArgumentException("Illegal pixel step");
        }
        while(y <= image.getHeight()) {
            while (x <= image.getWidth()) {
                int r = 0, g = 0, b = 0;
                int lastI = 0, lastJ = 0;
                for(int i = y; i < y+pixelSize; i++) {
                    for(int j = x; j< x+pixelSize; j++) {
                        if(i < image.getHeight() && j < image.getWidth()) {
                            int ConColorInt = image.getRGB(j,i);
                            Color ConColor = new Color(ConColorInt);
                            r += ConColor.getRed();
                            g += ConColor.getGreen();
                            b += ConColor.getBlue();
                            lastJ = j;
                            lastI = i;
                        }
                        else {
                            break;
                        }
                    }
                }
                int newR = r / pixelSize / pixelSize;
                if(newR >= 256) { newR = 0; }
                int newG = g / pixelSize / pixelSize;
                if(newG >= 256) { newG = 0; }
                int newB = b / pixelSize / pixelSize;
                if(newB >= 256) { newB = 0; }
                for(int i = y; i <= lastI; i++) {
                    for(int j = x; j<= lastJ; j++) {
                        image.setRGB(j,i, new Color(newR, newG, newB).getRGB());
                    }
                }
                x+=pixelSize;
            }
            x = 0;
            y+=pixelSize;
        }
        return image;
    }

    /**
     * Function that allows to set concrete size of the side of pixel square
     * @param coefficient - size in pixels of the side
     */
    @Override
    public void setPercentage(int coefficient) {
        this.pixelSize = coefficient;
    }
}
