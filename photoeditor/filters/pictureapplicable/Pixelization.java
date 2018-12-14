package ru.kpfu.itis.photoeditor.filters.pictureapplicable;

import ru.kpfu.itis.photoeditor.filters.PercentageVariable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixelization implements PictureApplicableFilter, PercentageVariable {
    private int pixelSize;
    public BufferedImage apply(BufferedImage image) throws IllegalArgumentException {
        int x = 0, y = 0;
        if(pixelSize < 0 || pixelSize >= image.getWidth() || pixelSize >= image.getHeight()) {
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

    @Override
    public void setPercentage(int coefficient) {
        this.pixelSize = coefficient;
    }
}
